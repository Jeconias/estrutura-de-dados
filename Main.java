import classes.grafo.*;
import exceptions.TableIndexException;

public class Main {

  public static void main(String args[]) {

    Grafo g = new Grafo();
    Vertice a, b, c, d, e, f;
    a = g.newVertice("0");
    b = g.newVertice("1");
    c = g.newVertice("2");
    d = g.newVertice("3");

    g.setVertices(a, b, c, d);

    /**
     * v1 v2 v3 v4 v5 v1 0 1 1 1 0 v2 1 0 0 0 1 v3 1 0 0 1 0 v4 1 0 1 0 1 v5 0 1 0 1
     * 0
     */

    try {

      g.setAresta(0, 1, false).setCusto(10);
      g.setAresta(1, 2, false).setCusto(5);
      g.setAresta(2, 3, false).setCusto(1);
      g.setAresta(3, 0, false).setCusto(3);

      // System.out.println(g.isAdjacent(c, b));
    } catch (TableIndexException x) {
      System.out.println(x.getMessage());
    }

    g.showGrafo(false);
    // System.out.println(g.isEule());

    g.vImpares().forEach((v) -> {
      // System.out.println(v.getElement());
    });

    g.carteiroChines();

    // g.removeVertice(c);
    // g.showGrafo(false);

  }
}