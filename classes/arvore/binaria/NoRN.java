package classes.arvore.binaria;

public class NoRN {

	public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";

	private Object 	elemento 		= null;
	private char 	tipo 			= 'J';
    private NoRN 	filhoEsquerdo 	= null;
    private NoRN 	filhoDireito 	= null;
    private NoRN 	pai 			= null;

	public NoRN(){}
    public NoRN(Object elemento, char tipo, NoRN filhoEsquerdo, NoRN filhoDireito, NoRN pai)
    {
		this.elemento 		= elemento;
		this.tipo 			= tipo;
        this.filhoEsquerdo 	= filhoEsquerdo;
        this.filhoDireito 	= filhoDireito;
        this.pai 			= pai;
    }
    
	public Object getElemento() {
		return this.elemento;
	}

	public NoRN setElemento(Object elemento) {
		this.elemento = elemento;
		return this;
	}

	public char getTipo() {
		return this.tipo;
	}

	/**
	 * R 	= Vermelho
	 * N 	= Negro
	 * NN 	= Duplo Negro
	 */
	public NoRN setTipo(char tipo) {
		this.tipo = tipo;
		return this;
	}

	public NoRN getFilhoEsquerdo() {
		return this.filhoEsquerdo;
	}

	public NoRN setFilhoEsquerdo(NoRN filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
		return this;
	}

	public NoRN getFilhoDireito() {
		return this.filhoDireito;
	}

	public NoRN setFilhoDireito(NoRN filhoDireito) {
		this.filhoDireito = filhoDireito;
		return this;
	}

	public NoRN getPai() {
		return this.pai;
	}

	public NoRN setPai(NoRN pai) {
		this.pai = pai;
		return this;
	}

	public NoRN getIrmao()
	{
		if(this.getPai() == null) return null;
		return ((ObjectCompare.compare(this.getPai().getElemento(), this.elemento) == 1) ? this.getPai().getFilhoDireito() : this.getPai().getFilhoEsquerdo());
	}

	public int getLado()
	{
		return (this.getPai().getFilhoDireito() == this) ? 1 : -1;
	}

	public NoRN getTio()
	{
		if(this.getPai() == null) return null;
		return this.getPai().getIrmao();
	}

	public NoRN getAvo()
	{
		if(this.pai == null) return null;
		return this.pai.getPai();
	}

	public String __toString()
	{
		return (this.tipo == 'R' ? ANSI_RED : ANSI_BLACK) + this.elemento;
	}

}