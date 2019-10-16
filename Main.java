import classes.grafo.*;
import exceptions.JokerTypeNotFound;
import exceptions.TableIndexException;

public class Main {

  public static void main(String args[]) {

    Aresta aa = null;
    Vertice a, b, c, d;
    Grafo g = new Grafo();
    a = g.setVertice("a");
    b = g.setVertice("b");
    c = g.setVertice("c");

    try {

      aa = g.setAresta(1, 2, false);
      // g.setAresta(0, 0, false);
      // g.setAresta(2, 1, true);
      // g.setAresta(1, 2, false);

      g.showTable();
      System.out.println();
      // g.removeVertice(a);
      // g.removeVertice(b);
      g.removeAresta(aa);

    } catch (TableIndexException e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }

    g.showTable();

    // System.out.println(a.toString());
    // System.out.println(b.toString());
    System.out.println(g.arestasToString());

  }
}