import classes.arvore.binaria.*;

public class Main {

  public static void main (String args[])
  {

      // ARVORE RN
      ArvoreRN arn = new ArvoreRN(10);

      arn.inserir(20);
      arn.exibir();
      System.out.println(ArvoreRN.ANSI_RESET);
      arn.inserir(30);
      arn.exibir();
      System.out.println(ArvoreRN.ANSI_RESET);
      arn.inserir(40);
      arn.exibir();
      System.out.println(ArvoreRN.ANSI_RESET);
      arn.inserir(50);
      arn.exibir();
      System.out.println(ArvoreRN.ANSI_RESET);
      arn.inserir(60);
      arn.exibir();
      System.out.println(ArvoreRN.ANSI_RESET);
      arn.inserir(70);
      arn.exibir();
      System.out.println(ArvoreRN.ANSI_RESET);
      arn.inserir(80);
      arn.exibir();
      System.out.println(ArvoreRN.ANSI_RESET);
      arn.inserir(90);
      arn.exibir();
      System.out.println(ArvoreRN.ANSI_RESET);
      arn.inserir(75);

      arn.exibir();




      System.exit(0);
  }
}
