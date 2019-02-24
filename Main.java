import Classes.PilhaDB;
import Exceptions.*;

public class Main {

  public static void main (String args[])
  {

    PilhaDB pilha = new PilhaDB(3);

    try {
      pilha.push(1);
      System.out.println(pilha.top());
      
      pilha.push(10);
      System.out.println(pilha.top());
      
      System.out.println(pilha.pop());

      System.out.println(pilha.top());

    }catch(PilhaCheiaException | PilhaVaziaException ex)
    {
      System.out.println(ex);
    }

    






  }

}
