import Classes.Arvore.Binaria.*;

public class Main {

  public static void main (String args[])
  {

      // ARVORE AVL
      ArvoreAVL avl = new ArvoreAVL();

      avl.inserir(30);
      avl.inserir(10);
      avl.inserir(40);
      avl.inserir(5);
      avl.inserir(25);
      avl.inserir(3);
      avl.inserir(4);
      avl.inserir(1);

      avl.remover(25);
      avl.remover(30);
      avl.remover(40);
      avl.remover(10);
      //avl.remover(5);
      //avl.remover(1);


      avl.exibir();

      /*try {
        System.out.print( avl.isRoot((NoAVL) avl.procurar(70)) );
      } catch (ElementoNaoEncontradoException e) {
        System.out.print(e.getMessage());
      }*/
      System.exit(0);
  }
}
