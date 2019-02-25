package Interfaces;
import Exceptions.PilhaVaziaException;

public interface InterfacePilhaNaoLimitadaVP {

  public void pushRed(int value);
  public void pushBlack(int value);

  public int popRed() throws PilhaVaziaException;
  public int popBlack() throws PilhaVaziaException;

  public int topRed() throws PilhaVaziaException;
  public int topBlack() throws PilhaVaziaException;

  public int sizeRed();
  public int sizeBlack();

  public boolean isEmptyRed();
  public boolean isEmptyBlack();
   
}
