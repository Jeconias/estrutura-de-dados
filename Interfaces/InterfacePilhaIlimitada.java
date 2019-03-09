package interfaces;
import exceptions.*;

public interface InterfacePilhaIlimitada {

  public void push(int value);
  public int pop() throws PilhaVaziaException;
  public int top() throws PilhaVaziaException;
  public int size();
  public boolean isEmpty();

}
