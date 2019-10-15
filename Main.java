import classes.grafo.*;
import exceptions.JokerTypeNotFound;
import exceptions.TableIndexException;

public class Main {

  public static void main(String args[]) {

    Vertice a, b, c, d;
    Grafo g = new Grafo();
    a = g.setVertice("a");
    b = g.setVertice("b");
    c = g.setVertice("c");

    try {

      //g.setAresta(0, 0, false);
      g.setAresta(0, 2, false);
      g.setAresta(0, 1, true);
      g.setAresta(2, 1, true);

    } catch (TableIndexException e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }

    g.showTable();

    System.out.println(a.toString());
    System.out.println(c.toString());

  }
}