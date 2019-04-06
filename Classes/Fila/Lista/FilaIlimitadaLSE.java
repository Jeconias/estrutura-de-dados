package Classes.Fila.Lista;

import Classes.Pilha.Lista.ListaSimplesEncadeada;
import Exceptions.*;

public class FilaIlimitadaLSE {

    private ListaSimplesEncadeada inicio = null;
    private ListaSimplesEncadeada fim = null;
    private int size = 0;

    public void enfileirar(int value)
    {
      if(this.inicio == null){
          this.inicio = new ListaSimplesEncadeada(value, null);
          this.size++;
          return;
      }

      if(this.fim == null){
        this.fim = new ListaSimplesEncadeada(value, null);
        this.inicio.setNext(this.fim);
        this.size++;
        return;
      }

      ListaSimplesEncadeada noTemp = new ListaSimplesEncadeada(value, null);

      this.fim.setNext(noTemp);
      this.fim = noTemp;
      this.size++;
    }

    public int desenfileirar() throws FilaVaziaException
    {
      // VERIFICAR SE A PILHA ESTA VAZIA
      if(this.estaVazia() == true) throw new FilaVaziaException("Fila Vazia");

      // PEGANDO O VALOR DO PRIMEIRO OBJ INSERIDO (TOPO)
      int intTemp = this.inicio.getValue();

      // REMOVENDO O ULTIMO OBJ INSERIDO
      this.inicio = this.inicio.getNext();

      this.size--;
      return intTemp;
    }

    public int inicio()
    {
      return this.inicio.getValue();
    }

    public int tamanho()
    {
      return this.size;
    }

    public boolean estaVazia()
    {
      return (this.inicio == null) ? true : false;
    }

}
