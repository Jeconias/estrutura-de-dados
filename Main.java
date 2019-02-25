import Classes.*;
import Exceptions.*;

public class Main {

  public static void main (String args[])
  {

    PilhaNaoLimitadaVP pilha = new PilhaNaoLimitadaVP(4);

    pilha.pushBlack(1);
    pilha.pushBlack(22);
    pilha.pushBlack(333);
    pilha.pushBlack(332);
    pilha.pushBlack(31);
    pilha.pushBlack(10103);

    pilha.pushRed(100);
    pilha.pushRed(200);

    try {
      // Teste
      System.out.println(pilha.topBlack());
      System.out.println(pilha.topRed());
      
    }catch(PilhaVaziaException ex){
      System.out.println(ex);
    }

  }

}
