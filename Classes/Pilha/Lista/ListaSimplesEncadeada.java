package Classes.Pilha.Lista;

public class ListaSimplesEncadeada {
    private int value;
    private ListaSimplesEncadeada next;

    public ListaSimplesEncadeada(int value, ListaSimplesEncadeada next)
    {
        this.value = value;
        this.next = next;
    }

    public int getValue()
    {
        return this.value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public ListaSimplesEncadeada getNext()
    {
        return this.next;
    }

    public void setNext(ListaSimplesEncadeada next)
    {
        this.next = next;
    }
}
