package Classes.Arvore.Binaria;

public class No {

    private int elemento;
    private No filhoEsquerdo;
    private No filhoDireito;
    private No pai;

    public No(){}
    public No(int elemento, No filhoEsquerdo, No filhoDireito, No pai)
    {
        this.elemento = elemento;
        this.filhoEsquerdo = filhoEsquerdo;
        this.filhoDireito = filhoDireito;
        this.pai = pai;
    }
    
	public int getElemento() {
		return this.elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

	public No getFilhoEsquerdo() {
		return this.filhoEsquerdo;
	}

	public void setFilhoEsquerdo(No filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}

	public No getFilhoDireito() {
		return this.filhoDireito;
	}

	public void setFilhoDireito(No filhoDireito) {
		this.filhoDireito = filhoDireito;
	}

	public No getPai() {
		return this.pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}
}