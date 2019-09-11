package classes.tabelahash;

public class No {
    
    private Object valor;
    private int chave;
    private No proximo;

    public No(){}

    public Object getValor() {
        return this.valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getChave() {
        return this.chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public No getProximo() {
        return this.proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    
}