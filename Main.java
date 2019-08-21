import Classes.Arvore.Binaria.*;

public class Main {

  public static void main (String args[])
  {

      // ARVORE AVL
      ArvoreAVL avl = new ArvoreAVL();

      avl.inserir(1);
      avl.inserir(2);
      avl.inserir(3);
      avl.inserir(4);
      avl.inserir(5);
      avl.inserir(6);
      //avl.inserir(7);
      avl.inserir(8);
      avl.inserir(9);
      avl.inserir(10);

      avl.remover(9);
      avl.remover(10);
      avl.remover(4);


      avl.exibir();

      /*try {
        System.out.print( avl.isRoot((NoAVL) avl.procurar(70)) );
      } catch (ElementoNaoEncontradoException e) {
        System.out.print(e.getMessage());
      }*/
      System.exit(0);
  }
}
