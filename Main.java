import Classes.*;
import Exceptions.*;

public class Main {

  public static void main (String args[])
  {

    PilhaNaoLimitada pilha = new PilhaNaoLimitada(3);

    try {
      pilha.push(1);
      System.out.println(pilha.top());
      
      pilha.push(10);
      System.out.println(pilha.top());
      
      System.out.println(pilha.pop());

      System.out.println(pilha.top());

    }catch(PilhaVaziaException ex)
    {
      System.out.println(ex);
    }

  }

}
