package Interfaces;
import Classes.NoLDE;

public interface InterfaceTADListaDuplamenteEncadeada {

    // METODOS GENERICOS
    public int size();
    public boolean isEmpty();

    // METODOS DE FILA
    public boolean isFirst(int v);
    public boolean isLast(int v);

    //METODOS PARA ACESSAR
    public int first();
    public int last();
    public int before(NoLDE o);
    public int after(NoLDE o);

    //METODOS PARA ATUALIZAR
    public void replaceElement(NoLDE n, NoLDE o);
    public void swapElements(NoLDE n, NoLDE o);
    public void insertBefore(NoLDE n, NoLDE o);
    public void insertAfter(NoLDE n, NoLDE o);
    public void insertFirst(NoLDE o);
    public void insertLast(int o);
    public void remove(NoLDE n);
}