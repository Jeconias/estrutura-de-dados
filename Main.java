import Classes.*;
import Exceptions.*;

public class Main {

  public static void main (String args[])
  {

      TADListaDuplamenteEncadeada tadLista = new TADListaDuplamenteEncadeada();

      NoLDE a = tadLista.insertFirst(5);
      NoLDE b = tadLista.insertLast(616);
      NoLDE c = tadLista.insertLast(21);
      NoLDE d = tadLista.insertLast(54);
      tadLista.remove(d);
      //tadLista.replaceElement(a, b);

      System.out.println(tadLista.first().getValue());
      System.out.println(tadLista.last().getValue());
      //System.out.println(tadLista.isFirst(a));
      //System.out.println(tadLista.isLast(a));

      System.out.println("---");
      //tadLista.swapElements(a, b);

      //System.out.println(tadLista.first().getValue());
      //System.out.println(tadLista.last().getValue());
      //System.out.println(tadLista.isFirst(b));
      //System.out.println(tadLista.isLast(b));
























    
    
    
    
    
    
    
    
    
    
    /*TADVector TADv = new TADVector();

    try {
      TADv.insertAtRank(0, 10);
      TADv.insertAtRank(1, 20);
      TADv.insertAtRank(2, 30);
      TADv.insertAtRank(3, 40);
      TADv.insertAtRank(4, 50);

      //TADv.insertAtRank(2, 520);
      TADv.replaceAtRank(0, 520);
      //TADv.insertAtRank(0, 200);
    } catch (TADVectorException e) {
      System.out.println(e.getMessage());
    }*/


  }

}
