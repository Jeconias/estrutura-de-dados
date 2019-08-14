package Classes.Arvore.Binaria;

import java.util.List;
import java.util.ArrayList;
import Exceptions.ElementoNaoEncontradoException;

public class ArvoreBinariaDePesquisa {

    protected No root                   = null;
    protected ArrayList<No> listaNos    = null;
    private int cacheNos                = -1;
    protected int size                  = 0;

    public ArvoreBinariaDePesquisa(){}


    public boolean inserir(int novoElemento)
    {   
        
        if(this.root == null){
            this.root = new No(novoElemento, null, null, null);
            return true;
        }

        No noAux = this.pesquisar(novoElemento, this.root);
        No novoFilho = new No(novoElemento, null, null, noAux);
        int elemento = noAux.getElemento();

        if(novoElemento == elemento) return false; // O ELEMENTO JA EXISTE NA ARVORE

        if(novoElemento < elemento) 
        {
            noAux.setFilhoEsquerdo(novoFilho);
        }else{
            noAux.setFilhoDireito(novoFilho);
        }
        this.size++;
        return true;
    }

    public No procurar(int elemento) throws ElementoNaoEncontradoException
    {
        No noAux = this.pesquisar(elemento, this.root);
        if(noAux.getElemento() != elemento){
            throw new ElementoNaoEncontradoException("Elemento não encontrado");
        }
        return noAux;
    }

    public boolean remover(int elemento)
    {
        No noAux = this.pesquisar(elemento, this.root);
        int elementoAtual = noAux.getElemento();

        if(elementoAtual != elemento) return false; // O ELEMENTO PARA REMOVER NAO EXISTE

        // REMOÇÃO QUANDO O NÓ NÃO TEM FILHO
        if(this.ehExterno(noAux))
        {
            if(this.root == noAux)
            {
                this.root = null;
                this.size--;
                return true;
            }else{
                if(noAux.getPai().getFilhoDireito() == noAux)
                {
                    noAux.getPai().setFilhoDireito(null);
                }else if(noAux.getPai().getFilhoEsquerdo() == noAux)
                {
                    noAux.getPai().setFilhoEsquerdo(null);
                }
                noAux.setPai(null);
                this.size--;
                return true;
            }
        }

        // REMOVER O NÓ QUANDO POSSUI 1 FILHO
        if(this.totalFilhos(noAux) == 1)
        {
            No noAuxFilho;
            if(this.root == noAux)
            {
                noAuxFilho = (this.temFilhoDireito(this.root)) ? this.root.getFilhoDireito() : this.root.getFilhoEsquerdo();
                noAuxFilho.setPai(null);
                this.root = noAuxFilho;
                this.size--;
                return true;
            }else{
                noAuxFilho = (this.temFilhoDireito(noAux)) ? noAux.getFilhoDireito() : noAux.getFilhoEsquerdo();
                noAuxFilho.setPai(noAux.getPai());
                if(noAux.getPai().getFilhoDireito() == noAux)
                {
                    noAux.getPai().setFilhoDireito(noAuxFilho);
                }else{
                    noAux.getPai().setFilhoEsquerdo(noAuxFilho);
                }
                noAux.setPai(null);
                noAux.setFilhoDireito(null);
                noAux.setFilhoEsquerdo(null);
                return true;
            }

        // REMOÇÃO QUANDO O NÓ TEM 2 FILHOS
        }else if(this.totalFilhos(noAux) == 2){

            No auxFilho = noAux.getFilhoDireito();
            while(auxFilho.getFilhoEsquerdo() != null)
            {
                auxFilho.getFilhoEsquerdo();
            }
            int elementoFilho = auxFilho.getElemento();
            this.remover(elementoFilho);
            noAux.setElemento(elementoFilho);
            this.size--;
            return true;
        }
        return false;
    }

    public ArrayList<No> nos(int ordem)
    {
        if(this.cacheNos == ordem && this.size == this.listaNos.size()) return this.listaNos;
        this.listaNos = new ArrayList<No>();

        if(ordem == 0) this.preOrdem(this.root);
        if(ordem == 1) this.inOrdem(this.root);
        if(ordem == 2) this.posOrdem(this.root);
        this.cacheNos = ordem;

        return this.listaNos;
    }

    protected void preOrdem(No noAux)
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

    protected void inOrdem(No noAux)
    {
        if(noAux == null) return;

        if(this.temFilhoEsquerdo(noAux)){
            this.inOrdem(noAux.getFilhoEsquerdo());
        }

        this.listaNos.add(noAux);

        if(this.temFilhoDireito(noAux)){
            this.inOrdem(noAux.getFilhoDireito());
        }
    }

    protected void posOrdem(No noAux)
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

    public int altura(No noAux)
    {
        if(noAux == null || this.ehExterno(noAux)) return 0;
        
        int i, h = 0;

        List<No> filhos = new ArrayList<No>();
        filhos.add(noAux.getFilhoEsquerdo());
        filhos.add(noAux.getFilhoDireito());

        for(i = 0; i < filhos.size(); i++)
        {
            h = Math.max(h,this.altura(filhos.get(i)));
        }
        return 1+h;
    }

    public int profundidade(No noAux)
    {
        if(this.root == noAux) return 0;
        return 1 + this.profundidade(noAux.getPai());
    }

    public No pesquisar(int elemento, No noAux)
    {
        if(elemento == noAux.getElemento() || this.ehExterno(noAux)) return noAux;
        if(elemento < noAux.getElemento() && this.temFilhoEsquerdo(noAux)) return this.pesquisar(elemento, noAux.getFilhoEsquerdo());
        if(elemento > noAux.getElemento() && this.temFilhoDireito(noAux)) return this.pesquisar(elemento, noAux.getFilhoDireito());
        return noAux;
    }

    private Boolean temFilhoEsquerdo(No noAux)
    {
        return (noAux.getFilhoEsquerdo() != null) ? true : false;
    }

    private Boolean temFilhoDireito(No noAux)
    {
        return (noAux.getFilhoDireito() != null) ? true : false;
    }

    private int totalFilhos(No noAux)
    {
        return (this.temFilhoDireito(noAux) && this.temFilhoEsquerdo(noAux)) ? 2 : (this.ehExterno(noAux)) ? 0 : 1;
    }

    private Boolean ehExterno(No noAux) 
    {
        return (this.temFilhoEsquerdo(noAux) || this.temFilhoDireito(noAux)) ? false : true;
    }

    public int size()
    {
        return this.size;
    }

    public void exibir()
    {
        ArrayList<No> nos = this.nos(1);
        int totalNos = nos.size();
        int linhas = (this.altura(this.root) + 1);
        int [][] tabela = new int[ linhas ][totalNos];

        for(int i = 0; i < totalNos; i++)
        {
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
    }

}