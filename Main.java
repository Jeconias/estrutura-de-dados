import Classes.Fila.Array.*;
import Classes.Fila.Lista.*;
import Classes.Lista.*;
import Classes.Pilha.Array.*;
import Classes.Pilha.Lista.*;
import Classes.Sequencia.Lista.*;
import Classes.Vector.Array.*;
import Classes.Arvore.Binaria.*;
import Exceptions.*;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

  public static void main (String args[])
  {

    // TAD FILA COM ARRAY
    FilaIlimitada FilaIlimitada = new FilaIlimitada();

    // TAD FILA COM LISTA SIMPLES ENCADEADA
    FilaIlimitadaLSE FilaIlimitadaLSE = new FilaIlimitadaLSE();

    // TAD LISTA COM LISTA DUPLAMENTE ENCADEADA
    TADListaDuplamenteEncadeada TADListaDuplamenteEncadeada = new TADListaDuplamenteEncadeada();

    // TAD PILHA COM ARRAY
    PilhaLimitada PilhaLimitada = new PilhaLimitada(10);

    // TAD PILHA COM ARRAY
    PilhaIlimitada PilhaIlimitada = new PilhaIlimitada(10);

    // TAD PILHA COM ARRAY (PILHA RUBRO)
    PilhaIlimitadaVP PilhaIlimitadaVP = new PilhaIlimitadaVP(10);

    // TAD SEQUENCIA COM LISTA DUPLAMENTE LIGADA
    TADSequenciaLDE TADSequenciaLDE = new TADSequenciaLDE();
    
    // TAD VECTOR COM ARRAY
    TADVector TADVector = new TADVector();

    // ARVORE BINARIA
    ArvoreBinaria ArvB = new ArvoreBinaria();

    // MENU PARA TESTAR A ARVORE BINARIA
    drawMenuArvore(ArvB);



    
    /*av.insert(20);
    av.insert(15);
        av.insert(1000);
        av.insert(11);
        av.insert(16);
        av.insert(32);
        av.insert(2000);
        av.insert(12);
        av.insert(25);

        //av.swapElements(av.search(1000), av.search(15));
        av.replace(av.search(20), 5);
        //av.remove(av.search(50));
        //av.remove(av.search(16));

        //av.insert(51);
        av.drawTree();*/

  }

  public static void drawMenuArvore(ArvoreBinaria ArvB)
  {
    Scanner SC = new Scanner(System.in);
    boolean loop = true;
    int in, input, output;
    No noTmp = null;
    
    System.out.println("### Opcoes da Arvore Binaria ###\n");
    System.out.print("[1] - Inserir\n[2] - Ler\n[3] - Atualizar\n[4] - Remover o ultimo no selecionado\n\n[5] - Tamanho\n[6] - Altura\n[7] - Profundidade\n[8] - Parente\n[9] - Possui Filho Esquerdo\n[10] - Possui Filho Direito\n\n[11] - isEmpty\n[12] - isInternal\n[13] - isExternal\n[14] - isRoot\n\n[15] - Exibir\n[0] - Sair\n");

    while(loop)
    {
      System.out.print(": ");
      try {
        in = SC.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("### Error: Voce deve fornecer um inteiro entre 0 e 15.\n");
        SC.nextLine();
        continue;
      }

      try {
        SC.nextLine();
        switch(in)
        {
          case 1:
            System.out.println("Número do nó para inserir: ");
            ArvB.insert(SC.nextInt());
          break;
          case 2:
            System.out.println("Nó para ler: ");
            noTmp = ArvB.search(SC.nextInt());
          break;
          case 3:
            output = ArvB.replace(noTmp, SC.nextInt());
            if(output == -1)
            {
              System.out.println("Esse numero já existe.");
            }else{
              System.out.println(noTmp.getElemento() + " trocado por " + output);
            }
          break;
          case 4:
            noTmp = ArvB.remove(noTmp);
            System.out.println(noTmp.getElemento() + " removido.");
          break;
          case 5:
            System.out.println("Tamanho da Arvore: " + ArvB.size());
          break;
          case 6:
            System.out.println("Altura da Arvore: " + ArvB.height(noTmp));
          break;
          case 7:
            System.out.println("Profundidade da Arvore: " + ArvB.depth(noTmp));
          break;
          case 8: 
            System.out.println("Parente do ultimo nó selecionado: " + ArvB.parent(noTmp).getElemento());
          break;
          case 9:
            System.out.println( (ArvB.hasLeftChild(noTmp)) ? "Sim":"Nao" );
          break;
          case 10:
            System.out.println( (ArvB.hasRightChild(noTmp)) ? "Sim":"Nao" );
          break;
          case 11:
            System.out.println( (ArvB.isEmpty()) ? "Sim":"Nao" );
          break;
          case 12:
            System.out.println( (ArvB.isInternal(noTmp)) ? "Sim":"Nao" );
          break;
          case 13:
            System.out.println( (ArvB.isExterno(noTmp)) ? "Sim":"Nao" );
          break;
          case 14:
            System.out.println( (ArvB.isRoot(noTmp)) ? "Sim":"Nao" );
          break;
          case 15:
            System.out.println("\n\n\n\n\n\n");
            ArvB.drawTree();
          break;
          case 0:
            System.out.println("Bye");
            loop = false;
          break;
        }
      } catch (InputMismatchException e) {
        System.out.println("### Error: Voce deve fornecer um inteiro.\n");
        SC.nextLine();
      }
      
    }
  }
}
