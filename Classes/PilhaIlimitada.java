package classes;
import interfaces.InterfacePilhaIlimitada;
import exceptions.*;

public class PilhaIlimitada implements InterfacePilhaIlimitada {

  int [] dataBase;
  int position;

  public PilhaIlimitada(int size)
  {
    this.dataBase = new int[size];
    this.position = -1;
  }

  public void push(int value)
  {
    if(this.position == (this.dataBase.length - 1))
    {

      int [] dataBaseTemp = new int[this.dataBase.length * 2];
      int i;

      for(i = 0; i < this.dataBase.length; i++)
      {
        dataBaseTemp[i] = this.dataBase[i];
      }

      this.position++;
      dataBaseTemp[this.position] = value;

      this.dataBase = dataBaseTemp;
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
