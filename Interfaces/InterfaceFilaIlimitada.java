package interfaces;
import exceptions.FilaVaziaException;

public interface InterfaceFilaIlimitada {

    public void enfileirar(int value);
    public int desenfileirar() throws FilaVaziaException;
    public int inicio();
    public int tamanho();
    public boolean estaVazia();
    
    

}