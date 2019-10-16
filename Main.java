import classes.arvore.binaria.*;

public class Main {

  public static void main(String args[]) {

    // ARVORE RN
    ArvoreRN arn = new ArvoreRN(10);

    arn.inserir(20);
    arn.inserir(30);
    arn.inserir(40);
    arn.inserir(45);
    arn.inserir(50);
    arn.inserir(60);
    arn.inserir(70);

    arn.remover(40);
    arn.remover(45);
    arn.remover(60);
    arn.remover(20);
    arn.remover(70);

    arn.exibir();

    System.exit(0);
  }
}
