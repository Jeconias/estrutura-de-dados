import classes.grafo.*;
import exceptions.JokerTypeNotFound;
import exceptions.TableIndexException;

public class Main {

  public static void main(String args[]) {

    Aresta aa = null;
    Vertice a, b, c, d, e;
    Grafo g = new Grafo();
    a = g.setVertice("a");
    b = g.setVertice("b");
    c = g.setVertice("c");
    d = g.setVertice("d");
    e = g.setVertice("e");

    try {

      aa = g.setAresta(1, 2, true);
      g.setAresta(0, 0, false);
      g.setAresta(2, 2, false);
      g.setAresta(3, 1, false);
      g.setAresta(4, 1, true);
      g.setAresta(4, 1, false);

      //g.showTable();
      //System.out.println();
      // g.removeVertice(a);
      // g.removeVertice(b);
      //g.removeAresta(aa);

    } catch (TableIndexException err) {
      System.out.println(err.getMessage());
      System.exit(1);
    }

    g.showTable();

    // System.out.println(a.toString());
    // System.out.println(b.toString());
    System.out.println(g.arestasToString());

  }
}