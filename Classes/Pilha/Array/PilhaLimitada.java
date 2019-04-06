package Classes.Pilha.Array;

import Interfaces.InterfacePilhaLimitada;
import Exceptions.*;

public class PilhaLimitada implements InterfacePilhaLimitada {

  int [] dataBase;
  int position;

  public PilhaLimitada(int size)
  {
    this.dataBase = new int[size];
    this.position = -1;
  }

  public void push(int value) throws PilhaCheiaException
  {
    if(this.position == (this.dataBase.length - 1))
    {
      throw new PilhaCheiaException("Pilha Cheia");
    }else{
      this.position++;
      this.dataBase[this.position] = value;
    }
  }

  public int pop() throws PilhaVaziaException
  {
    if(this.isEmpty())
    {
      throw new PilhaVaziaException("Pilha Vazia");
    }else{
      this.position--;
      return this.dataBase[this.position + 1];
    }
  }

  public int size()
  {
    return this.position + 1;
  }

  public boolean isEmpty()
  {
    return this.position == -1 ? true : false;
  }

  public int top() throws PilhaVaziaException
  {
    if(this.isEmpty())
    {
      throw new PilhaVaziaException("Pilha Vazia");
    }else{
      return this.dataBase[this.position];
    }
  }

}
