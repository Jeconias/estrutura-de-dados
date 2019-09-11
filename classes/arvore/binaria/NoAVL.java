package classes.arvore.binaria;

public class NoAVL extends No {

    private int fatorDeBalanceamento;

    public NoAVL (){}
    public NoAVL(int elemento, int fb, No filhoEsquerdo, No filhoDireito, No pai)
    {
        super(elemento, filhoEsquerdo, filhoDireito, pai);
        this.fatorDeBalanceamento = fb;
    }

    public int getFB()
    {
        return this.fatorDeBalanceamento;
    }

    public void setFB(int fb)
    {
        this.fatorDeBalanceamento = fb;
    }
}
