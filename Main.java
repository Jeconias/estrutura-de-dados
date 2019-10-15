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

      g.setAresta(0, "<>", 0);
      g.setAresta(1, "<", 2);
      g.setAresta(2, ">", 2);
      g.removeVertice(c);
      d = g.setVertice("d");
      g.setAresta(2, "<>", 2);
      g.removeVertice(d);

    } catch (TableIndexException | JokerTypeNotFound e) {
      e.printStackTrace();
    }

    g.showTable();

  }
}
