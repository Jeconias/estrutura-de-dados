import classes.arvore.binaria.*;

public class Main {

  public static void main (String args[])
  {

      // ARVORE RN
      ArvoreRN arn = new ArvoreRN(1);
      arn.inserir(2);
      arn.inserir(3);
      arn.inserir(4);
      arn.inserir(5);
      arn.inserir(6);
      arn.inserir(7);
      arn.inserir(8);

      arn.exibir();




      System.exit(0);
  }
}
