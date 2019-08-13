package Classes.Arvore.Binaria;

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
        int lado;

        if(novoElemento == elemento) return false; // O ELEMENTO JA EXISTE NA ARVORE
        
        if(novoElemento < elemento)
        {
            noAux.setFilhoEsquerdo(novoFilho);
            lado = 1;
            //noAux.setFB( noAux.getFB() + 1 );
        }else{
            noAux.setFilhoDireito(novoFilho);
            lado = -1;
            //noAux.setFB( noAux.getFB() - 1);
        }

        this.balancear(noAux, lado);

        this.size++;
        return true;
    }

    private void balancear(NoAVL noPai, int lado)
    {
        noPai.setFB( noPai.getFB() + lado );
        int fb = noPai.getFB();

        if(lado == 1 && fb == 0 || lado == -1 && fb == 0) return; // criterio de parada da insercao
        if(lado == -1 && fb != 0 || lado == 1 && fb != 0) return; // criterio de parada da remocao

        if(fb == 2 && noPai.getFilhoEsquerdo() != null && ((NoAVL) noPai.getFilhoEsquerdo()).getFB() < 0)
        {
            // rotacao dupla direita
        }else if(fb == -2 && noPai.getFilhoDireito() != null && ((NoAVL) noPai.getFilhoDireito()).getFB() > 0 ){
            // rotacao dupla esquerda
        }else if(fb == -2){
            // rotação esquerda simples
            this.rotacaoEsquerdaSimples(noPai);
        }else if(fb == 2){
            // rotacao direita simples
            this.rotacaoDireitaSimples(noPai);
        }

        if(noPai.getPai() == null) return;
        this.balancear((NoAVL) noPai.getPai(), lado);
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
            if(noPai.getPai() != null) noPai.getPai().setFilhoDireito(subArvoreDireita);
        }

        // FALTA ATUALIZAR O FB
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
            if(noPai.getPai() != null) noPai.getPai().setFilhoEsquerdo(subArvoreEsquerda);
        }

        // FALTA ATUALIZAR O FB

    }

}

