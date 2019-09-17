import classes.arvore.binaria.*;

public class Main {

  public static void main (String args[])
  {

      // ARVORE RN
      ArvoreRN arn = new ArvoreRN(10);

      arn.inserir(20);
      arn.inserir(30);
      arn.inserir(40);
      arn.inserir(50);
      arn.inserir(60);
      arn.inserir(70);
      arn.inserir(80);
      arn.inserir(90);
      arn.inserir(75);
      arn.inserir(100);
      arn.inserir(85);
      arn.exibir();
      arn.inserir(110);
      
      //arn.exibir();
      //arn.remover(40);
      arn.exibir();




      System.exit(0);
  }
}
