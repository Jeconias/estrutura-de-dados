package Interfaces;
import Exceptions.*;

public interface InterfacePilhaLimitada {

  public void push(int value) throws PilhaCheiaException;
  public int pop() throws PilhaVaziaException;
  public int top() throws PilhaVaziaException;
  public int size();
  public boolean isEmpty();

}
