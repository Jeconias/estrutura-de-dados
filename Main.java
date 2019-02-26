import Classes.*;
import Exceptions.*;

public class Main {

  public static void main (String args[])
  {

    PilhaIlimitada pilha = new PilhaIlimitada(2);
    PilhaIlimitadaVP pilhaVP = new PilhaIlimitadaVP(4);

    pilha.push(10);
    pilha.push(11);
    pilha.push(4);

    try {
      System.out.println(pilha.top());
      System.out.println(pilha.pop());
      System.out.println(pilha.size());
    }catch(PilhaVaziaException ex){
      System.out.println(ex);
    }

    System.out.println("##### PILHA VP / Vermelho e Preto #####");

    pilhaVP.pushBlack(1);
    pilhaVP.pushBlack(22);
    pilhaVP.pushBlack(333);
    pilhaVP.pushBlack(332);
    pilhaVP.pushBlack(31);
    pilhaVP.pushBlack(10103);

    pilhaVP.pushRed(100);
    pilhaVP.pushRed(200);

    try {
      // Teste
      System.out.println(pilhaVP.topBlack());
      System.out.println(pilhaVP.topRed());

    }catch(PilhaVaziaException ex){
      System.out.println(ex);
    }

  }

}
