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

      aa = g.setAresta(2, 0, false);
      g.setAresta(0, 2, false);
      g.setAresta(0, 1, false);
      g.setAresta(1, 2, false);
      g.setAresta(2, 3, true);

    } catch (TableIndexException err) {
      System.out.println(err.getMessage());
      System.exit(1);
    }

    System.out.println(g.dfs("2"));
    System.out.println();
    g.showTable();

  }
}