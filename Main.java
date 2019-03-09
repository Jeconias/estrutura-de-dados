import classes.*;
import exceptions.*;

public class Main {

  public static void main (String args[])
  {

    // FILA
    




















    // PILHA
    PilhaIlimitadaLSE pilhaLSE = new PilhaIlimitadaLSE();
    pilhaLSE.push(1);
    pilhaLSE.push(10);
    pilhaLSE.push(21);
    pilhaLSE.push(300);

    try {
      System.out.println(pilhaLSE.pop());
      System.out.println(pilhaLSE.pop());
      System.out.println(pilhaLSE.pop());
      System.out.println(pilhaLSE.pop());
      System.out.println(pilhaLSE.pop());
    } catch (PilhaVaziaException e) {
      System.out.println(e.getMessage());
    }
    



  }

}
