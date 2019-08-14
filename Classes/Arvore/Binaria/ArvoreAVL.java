package Classes.Arvore.Binaria;

import java.util.ArrayList;

public class ArvoreAVL extends ArvoreBinariaDePesquisa {

    public ArvoreAVL(){ super(); }

    // @Override
    public boolean inserir(int novoElemento)
    {
        if(this.root == null){
            this.root = new NoAVL(novoElemento, 0, null, null, null);
            return true;
        }

        NoAVL noAux = (NoAVL) this.pesquisar(novoElemento, this.root);
        NoAVL novoFilho = new NoAVL(novoElemento, 0, null, null, noAux);
        int elemento = noAux.getElemento();
        char lado;

        if(novoElemento == elemento) return false; // O ELEMENTO JA EXISTE NA ARVORE
        
        if(novoElemento < elemento)
        {
            noAux.setFilhoEsquerdo(novoFilho);
            lado = 'E';
        }else{
            noAux.setFilhoDireito(novoFilho);
            lado = 'D';
        }

        this.balancear(noAux, lado, 'i');

        this.size++;
        return true;
    }

    private void balancear(NoAVL noPai, char lado, char method)
    {
        NoAVL noAvlTemp = noPai;
        while(true)
        {
            this.incrementarFB(noAvlTemp, lado);
            int fb = noAvlTemp.getFB();

            if(method == 'i' && fb == 0 || method == 'r' && fb != 0 || noAvlTemp.getPai() == null) break;

            if(fb == 2 && noAvlTemp.getFilhoEsquerdo() != null && ((NoAVL) noAvlTemp.getFilhoEsquerdo()).getFB() < 0)
            {
                // rotacao dupla direita
            }else if(fb == -2 && noAvlTemp.getFilhoDireito() != null && ((NoAVL) noAvlTemp.getFilhoDireito()).getFB() > 0 ){
                // rotacao dupla esquerda
            }else if(fb == -2){
                // rotação esquerda simples
                this.rotacaoEsquerdaSimples(noAvlTemp);
            }else if(fb == 2){
                // rotacao direita simples
                this.rotacaoDireitaSimples(noAvlTemp);
            }
            noAvlTemp = (NoAVL) noPai.getPai();
        }

        //this.balancear((NoAVL) noPai.getPai(), lado, 'i');
    }

    public void incrementarFB(NoAVL no, char lado)
    {
        if(lado == 'E') no.setFB( no.getFB() + 1 );
        if(lado == 'D') no.setFB( no.getFB() - 1 );
    }

    // IF FB pai = -2 && FB subArvoreDireita <= 0
    private void rotacaoEsquerdaSimples(NoAVL noPai)
    {
        NoAVL subArvoreDireita = (NoAVL) noPai.getFilhoDireito();
        
        if(subArvoreDireita.getFilhoEsquerdo() != null)
        {
            subArvoreDireita.getFilhoEsquerdo().setPai( subArvoreDireita.getPai() );
            noPai.setFilhoDireito( subArvoreDireita.getFilhoEsquerdo() );
            noPai.setPai(subArvoreDireita);
            subArvoreDireita.setFilhoEsquerdo(noPai);
        }else{
            subArvoreDireita.setPai( (noPai.getPai() != null) ? noPai.getPai() : null );
            subArvoreDireita.setFilhoEsquerdo(noPai);
            
            noPai.setFilhoDireito(null);
            
            if(noPai.getPai() != null && noPai.getPai().getFilhoEsquerdo() == noPai)
            {
                noPai.getPai().setFilhoEsquerdo(subArvoreDireita);
            }else if(noPai.getPai() != null){
                noPai.getPai().setFilhoDireito(subArvoreDireita);
            }
            noPai.setPai(subArvoreDireita);
        }

        int noPaiNovoFb = noPai.getFB() + 1 - Math.min(subArvoreDireita.getFB(), 0);
        int subArvoreDireitaNovoFb = subArvoreDireita.getFB() + 1 + Math.max(noPai.getFB(), 0);

        noPai.setFB(noPaiNovoFb);
        subArvoreDireita.setFB(subArvoreDireitaNovoFb);

    }

    // IF FB pai = 2 && FB subArvoreEsquerda >= 0
    // Caso o FB na subárvore esquerda do nó desregulado for < 0, faz rotação dupla direita
    private void rotacaoDireitaSimples(NoAVL noPai)
    {
        NoAVL subArvoreEsquerda = (NoAVL) noPai.getFilhoEsquerdo();

        if(subArvoreEsquerda.getFilhoDireito() != null)
        {
            subArvoreEsquerda.getFilhoDireito().setPai( subArvoreEsquerda.getPai() );
            noPai.setFilhoEsquerdo( subArvoreEsquerda.getFilhoDireito() );
            noPai.setPai(subArvoreEsquerda);
            subArvoreEsquerda.setFilhoDireito(noPai);
        }else{
            subArvoreEsquerda.setPai( (noPai.getPai() != null) ? noPai.getPai() : null );
            subArvoreEsquerda.setFilhoDireito(noPai);
            
            noPai.setFilhoEsquerdo(null);
            
            if(noPai.getPai() != null && noPai.getPai().getFilhoEsquerdo() == noPai)
            {
                noPai.getPai().setFilhoEsquerdo(subArvoreEsquerda);
            }else if(noPai.getPai() != null){
                noPai.getPai().setFilhoDireito(subArvoreEsquerda);
            }
            noPai.setPai(subArvoreEsquerda);
        }

        int noPaiNovoFb = noPai.getFB() - 1 - Math.max(subArvoreEsquerda.getFB(), 0);
        int subArvoreEsquerdaNovoFb = subArvoreEsquerda.getFB() - 1 + Math.min(noPaiNovoFb, 0);

        noPai.setFB(noPaiNovoFb);
        subArvoreEsquerda.setFB(subArvoreEsquerdaNovoFb);
    }

    // @Override
    public void exibir()
    {
        ArrayList<No> nos = this.nos(1);
        int totalNos = nos.size();
        int linhas = (this.altura(this.root) + 1);
        int [][] tabela = new int[ linhas ][totalNos];
        String nosString = "\n\n";
        
        for(int i = 0; i < totalNos; i++)
        {
            nosString += "NO: "+ nos.get(i).getElemento() +" => FB: " + ((NoAVL)nos.get(i)).getFB() + "\n";
            tabela[ this.profundidade(nos.get(i)) ][i] = nos.get(i).getElemento();

        }

        for(int i = 0; i < linhas; i++)
        {
            for(int j = 0; j < totalNos; j++)
            {
                if(tabela[i][j] != 0)
                {
                    System.out.print(tabela[i][j] + "   "); 
                }else{
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }
        System.out.print(nosString);
    }

}

