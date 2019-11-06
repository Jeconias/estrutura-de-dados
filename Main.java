import classes.grafo.*;
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

      g.setAresta(0, 1, false).setPeso(2);
      g.setAresta(0, 2, false).setPeso(3);
      g.setAresta(0, 3, false).setPeso(6);

      g.setAresta(1, 4, false).setPeso(1);
      g.setAresta(1, 0, false).setPeso(4);

      g.setAresta(2, 0, false).setPeso(0);
      g.setAresta(2, 3, false).setPeso(4);

      g.setAresta(3, 0, false).setPeso(8);
      g.setAresta(3, 2, false).setPeso(9);
      g.setAresta(3, 4, false).setPeso(4);

      g.setAresta(4, 1, false).setPeso(1);
      g.setAresta(4, 3, false).setPeso(2);
      g.setAresta(4, 2, false).setPeso(3);

      System.out.println(g.isEule());

    } catch (TableIndexException err) {
      System.out.println(err.getMessage());
      System.exit(1);
    }

    // System.out.println(g.dfs("2"));
    // System.out.println();
    g.carteiroChines();
    // g.showTable();

  }
}