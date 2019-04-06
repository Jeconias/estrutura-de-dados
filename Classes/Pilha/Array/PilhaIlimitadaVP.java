package Classes.Pilha.Array;

import Interfaces.InterfacePilhaIlimitada;
import Exceptions.*;

public class PilhaIlimitadaVP {

  int [] dataBase;
  int positionRed, positionBlack;

  public PilhaIlimitadaVP(int size)
  {
    this.dataBase = new int[size];
    this.positionRed = -1;
    this.positionBlack = size;
  }

  public void pushRed(int value)
  {
    if(this.positionRed == (this.positionBlack - 1))
    {

      int [] dataBaseTemp = new int[this.dataBase.length * 2];
      int i, aux;

      // PASSANDO OS VALORES "VERMELHOS"
      for(i = 0; i < this.dataBase.length; i++)
      {
        dataBaseTemp[i] = this.dataBase[i];
      }

      aux = (this.dataBase.length * 2) - 1;
      // PASSANDO OS VALORES DO LADO PRETO (DIREITO)
      for(i = (this.dataBase.length - 1); i > this.positionBlack; i--)
      {
        dataBaseTemp[aux] = this.dataBase[i];
        aux--;
      }

      this.positionRed++;
      this.positionBlack = (this.dataBase.length * 2) - (this.dataBase.length - this.positionBlack);
      dataBaseTemp[this.positionRed] = value;

      this.dataBase = dataBaseTemp;
    }else{
      this.positionRed++;
      this.dataBase[this.positionRed] = value;
    }
  }

  public void pushBlack(int value)
  {
    if(this.positionRed == (this.positionBlack - 1))
    {

      int [] dataBaseTemp = new int[this.dataBase.length * 2];
      int i, aux;

      // PASSANDO OS VALORES "VERMELHOS"
      for(i = 0; i < this.dataBase.length; i++)
      {
        dataBaseTemp[i] = this.dataBase[i];
      }

      aux = (this.dataBase.length * 2) - 1;
      // PASSANDO OS VALORES DO LADO PRETO (DIREITO)
      for(i = (this.dataBase.length - 1); i > this.positionBlack; i--)
      {
        dataBaseTemp[aux] = this.dataBase[i];
        aux--;
      }

      this.positionBlack = ((this.dataBase.length * 2) - (this.dataBase.length - this.positionBlack)) - 1;
      dataBaseTemp[this.positionBlack] = value;

      this.dataBase = dataBaseTemp;
    }else{
      this.positionBlack--;
      this.dataBase[this.positionBlack] = value;
    }
  }

  public int popRed() throws PilhaVaziaException
  {
    if(this.isEmptyRed())
    {
      throw new PilhaVaziaException("Pilha Vazia");
    }else{
      this.positionRed--;
      return this.dataBase[this.positionRed + 1];
    }
  }

  public int popBlack() throws PilhaVaziaException
  {
    if(this.isEmptyBlack())
    {
      throw new PilhaVaziaException("Pilha Vazia");
    }else{
      this.positionBlack++;
      return this.dataBase[this.positionBlack - 1];
    }
  }

  public int sizeRed()
  {
    return this.positionRed + 1;
  }

  public int sizeBlack()
  {
    return (this.dataBase.length - this.positionBlack);
  }

  public boolean isEmptyRed()
  {
    return this.positionRed == -1 ? true : false;
  }

  public boolean isEmptyBlack()
  {
    return this.positionBlack == this.dataBase.length ? true : false;
  }

  public int topRed() throws PilhaVaziaException
  {
    if(this.isEmptyRed())
    {
      throw new PilhaVaziaException("Pilha Vazia");
    }else{
      return this.dataBase[this.positionRed];
    }
  }

  public int topBlack() throws PilhaVaziaException
  {
    if(this.isEmptyBlack())
    {
      throw new PilhaVaziaException("Pilha Vazia");
    }else{
      return this.dataBase[this.positionBlack];
    }
  }

}
