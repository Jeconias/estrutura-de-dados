package classes.arvore.binaria;

import java.util.ArrayList;
import java.util.List;

public class ArvoreRN {

    public static final String ANSI_RESET = "\u001B[0m";

    private NoRN raiz;
    private int tamanho;
    private ArrayList<NoRN> listaNos;
    
    public ArvoreRN(Object novoElemento){
        this.raiz = (new NoRN()).setElemento(novoElemento).setTipo('N');
    }


    public NoRN inserir(Object novoElemento)
    {
        NoRN peRes = this.pesquisar(novoElemento, this.raiz); 
        NoRN novoNoRN = (new NoRN()).setElemento(novoElemento).setTipo('R');

        if(ObjectCompare.compare(novoElemento, peRes.getElemento()) ==  0) return null; // O valor já existe
        if(ObjectCompare.compare(novoElemento, peRes.getElemento()) ==  1) peRes.setFilhoDireito(novoNoRN);
        if(ObjectCompare.compare(novoElemento, peRes.getElemento()) == -1) peRes.setFilhoEsquerdo(novoNoRN);

        novoNoRN.setPai(peRes);
        this.casosInsercao(novoNoRN);
        this.tamanho++;
        return novoNoRN;
    }

    public void casosInsercao(NoRN novoNoRN)
    {
        String rotacao;

        // CASO 1: Se o pai é negro, não precisa fazer nada.
        if(novoNoRN.getPai() == null || novoNoRN.getPai().getTipo() == 'N'){
            System.out.println("testando "+novoNoRN.getElemento()+"caso 1");
            return;
        }
        if((Integer) novoNoRN.getElemento() == 80){
            System.out.println(novoNoRN.getLado());
        }
        // CASO 2: Se o pai do novo nó é rubro e o avó do novo nó é negro e o tio do novo nó é rubro
        if(novoNoRN.getPai().getTipo()      == 'R'
            && novoNoRN.getAvo()            != null 
            && novoNoRN.getAvo().getTipo()  == 'N'
            && novoNoRN.getTio()            != null 
            && novoNoRN.getTio().getTipo()  == 'R')
            {
                System.out.println("testando "+novoNoRN.getElemento()+" caso 2");
                // recolocação
                novoNoRN.getPai().setTipo('N').getIrmao().setTipo('N').getPai().setTipo('R');
                if(novoNoRN.getAvo() == this.raiz) novoNoRN.getAvo().setTipo('N');

                //Se o pai do avó do novo nó for rubro o processo deverá ser repetido fazendo novo_nó receber a cor do avó
                if(novoNoRN.getAvo().getPai() != null
                    && novoNoRN.getAvo().getPai().getTipo() == 'R')
                    {
                        System.out.println("testando "+novoNoRN.getElemento()+"caso 2b");
                        this.casosInsercao(novoNoRN.getAvo());
                    }
                return;
            }
        
            rotacao = this.detectarRotacao(novoNoRN);
            System.out.println(rotacao);
            this.rotacionar(rotacao, novoNoRN);
            this.casosInsercao(novoNoRN.getPai());
    }

    public void rotacionar(String tipoRotacao, NoRN no)
    {
        if(tipoRotacao.equals("NPF")) return;
        if(tipoRotacao.equals("RDS") || tipoRotacao.equals("RES")) this.rotacaoSimples(tipoRotacao, no.getAvo());
        if(tipoRotacao.equals("RED") || tipoRotacao.equals("RDD")) this.rotacaoDupla(tipoRotacao, no.getAvo());
    }

    public void rotacaoSimples(String rotacaoLado, NoRN no)
    {
        NoRN filho    = null;
        NoRN netoDoNo = null;

        if(rotacaoLado.equals("RES"))
        {

            filho    = no.getFilhoDireito();
            netoDoNo = filho.getFilhoEsquerdo();

            no.setFilhoDireito(netoDoNo).setTipo('R');
            filho.setFilhoEsquerdo(no).setTipo('N');

        }else if(rotacaoLado.equals("RDS")){

            filho    = no.getFilhoEsquerdo();
            netoDoNo = filho.getFilhoDireito();

            no.setFilhoEsquerdo(netoDoNo).setTipo('R');
            filho.setFilhoDireito(no).setTipo('N');

        }else{
            //lançar exceção
        }

        if(netoDoNo != null) netoDoNo.setPai(no);
        if(no.getPai() != null)
        {
            if(no.getLado() == 1)
            {
                no.getPai().setFilhoDireito(filho);
            }else{
                no.getPai().setFilhoEsquerdo(filho);
            }
        }
        
        filho.setPai(no.getPai());
        no.setPai(filho);

        if(no == this.raiz) this.raiz = filho.setPai(null);
    }

    public void rotacaoDupla(String rotacaoLado, NoRN no)
    {
        if(rotacaoLado.equals("RDD"))
        {
            this.rotacaoSimples("RES", no.getPai());
            this.rotacaoSimples("RDS", no.getPai());
        }else{
            this.rotacaoSimples("RDS", no.getPai());
            this.rotacaoSimples("RES", no.getPai());
        }
    }


    public String detectarRotacao(NoRN no)
    {
        // Checa se é necessário fazer uma rotação
        if(no.getPai().getTipo()        == 'R'
            && no.getAvo()              != null 
            && no.getAvo().getTipo()    == 'N'){
            if(no.getPai().getIrmao() == null || no.getPai().getIrmao().getTipo() == 'N')
            {
                //Caso 3a: Rotação direito simples
                if(no.getLado() == -1 && no.getPai().getLado() == -1) {
                    System.out.println("testando " + no.getElemento() + " RDS");
                    return "RDS";
                }
                
                //Caso 3b: Rotação esquerda simples
                if(no.getLado() == 1 && no.getPai().getLado() == 1){
                    System.out.println("testando "+no.getElemento()+" RES");
                    return "RES";
                } 

                //Caso 3c: Rotação esquerda dupla
                if(no.getLado() == -1 && no.getPai().getLado() == 1){
                    System.out.println("testando "+no.getElemento()+" RED");
                    return "RED";
                } 

                //Caso 3d: Rotação direito dupla
                if(no.getLado() == 1 && no.getPai().getLado() == -1) {
                    System.out.println("testando " + no.getElemento() + "RDD");
                    return "RDD";
                }
            }
        }
        return "NPF"; //nada para fazer
    }

    public NoRN pesquisar(Object elemento, NoRN inicioDaPesquisa)
    {
        if(ObjectCompare.compare(elemento, inicioDaPesquisa.getElemento()) == 0 || this.ehExterno(inicioDaPesquisa)) return inicioDaPesquisa;
        if(ObjectCompare.compare(elemento, inicioDaPesquisa.getElemento()) == -1 && this.temFilhoEsquerdo(inicioDaPesquisa)) return this.pesquisar(elemento, inicioDaPesquisa.getFilhoEsquerdo());
        if(ObjectCompare.compare(elemento, inicioDaPesquisa.getElemento()) == 1 && this.temFilhoDireito(inicioDaPesquisa)) return this.pesquisar(elemento, inicioDaPesquisa.getFilhoDireito());
        return inicioDaPesquisa;
    }

    private Boolean ehExterno(NoRN noAux) 
    {
        return (this.temFilhoEsquerdo(noAux) || this.temFilhoDireito(noAux)) ? false : true;
    }

    private Boolean temFilhoEsquerdo(NoRN noAux)
    {
        return (noAux.getFilhoEsquerdo() != null) ? true : false;
    }

    private Boolean temFilhoDireito(NoRN noAux)
    {
        return (noAux.getFilhoDireito() != null) ? true : false;
    }

    public ArrayList<NoRN> nos(int ordem)
    {
        this.listaNos = new ArrayList<NoRN>();

        if(ordem == 0) this.preOrdem(this.raiz);
        if(ordem == 1) this.inOrdem(this.raiz);
        if(ordem == 2) this.posOrdem(this.raiz);

        return this.listaNos;
    }

    protected void preOrdem(NoRN noAux)
    {
        if(noAux == null) return;

        this.listaNos.add(noAux);

        if(this.temFilhoEsquerdo(noAux)){
            this.preOrdem(noAux.getFilhoEsquerdo());
        }

        if(this.temFilhoDireito(noAux)){
            this.preOrdem(noAux.getFilhoDireito());
        }
    }

    protected void inOrdem(NoRN noAux)
    {
        if(noAux == null) return;

        if(this.temFilhoEsquerdo(noAux)){
            this.inOrdem(noAux.getFilhoEsquerdo());
        }

        this.listaNos.add(noAux);

        if(this.temFilhoDireito(noAux)){
            this.inOrdem(noAux.getFilhoDireito());
        }
        return;
    }

    protected void posOrdem(NoRN noAux)
    {
        if(noAux == null) return;

        if(this.temFilhoEsquerdo(noAux)){
            this.posOrdem(noAux.getFilhoEsquerdo());
        }

        if(this.temFilhoDireito(noAux)){
            this.posOrdem(noAux.getFilhoDireito());
        }

        this.listaNos.add(noAux);
    }

    public int altura(NoRN noAux)
    {
        if(noAux == null || this.ehExterno(noAux)) return 0;
        
        int i, h = 0;

        List<NoRN> filhos = new ArrayList<NoRN>();
        filhos.add(noAux.getFilhoEsquerdo());
        filhos.add(noAux.getFilhoDireito());

        for(i = 0; i < filhos.size(); i++)
        {
            h = Math.max(h,this.altura(filhos.get(i)));
        }
        return 1+h;
    }

    public int tamanho()
    {
        return this.tamanho;
    }

    public int profundidade(NoRN noAux)
    {
        if(this.raiz == noAux) return 0;
        return 1 + this.profundidade(noAux.getPai());
    }

    public void exibir()
    {
        ArrayList<NoRN> nos = this.nos(1);
        int totalNos = nos.size();
        int linhas = (this.altura(this.raiz) + 1);
        NoRN [][] tabela = new NoRN[ linhas ][totalNos];

        for(int i = 0; i < totalNos; i++)
        {
            tabela[ this.profundidade(nos.get(i)) ][i] = nos.get(i);
        }

        for(int i = 0; i < linhas; i++)
        {
            for(int j = 0; j < totalNos; j++)
            {
                NoRN tmp = tabela[i][j];
                if(tmp != null)
                {
                    System.out.print(tmp.__toString() + "  "); 
                }else{
                    System.out.print("    ");
                }
            }
            System.out.print("\n\n\n");
        }
    }
}

