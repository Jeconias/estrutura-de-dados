import classes.*;
import exceptions.*;

public class Main {

  public static void main (String args[])
  {

    // FILA
    FilaIlimitada filaIlimitada = new FilaIlimitada();
    

    try {
      filaIlimitada.enfileirar(114);
      filaIlimitada.enfileirar(100);
      filaIlimitada.enfileirar(241);
      filaIlimitada.enfileirar(61);

      System.out.println(filaIlimitada.tamanho());
      System.out.println(filaIlimitada.desenfileirar());
      System.out.println(filaIlimitada.desenfileirar());
      System.out.println(filaIlimitada.desenfileirar());
      System.out.println(filaIlimitada.desenfileirar());
      
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    // PILHA
    /*PilhaIlimitadaLSE pilhaLSE = new PilhaIlimitadaLSE();
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
    }*/
    



  }

}
