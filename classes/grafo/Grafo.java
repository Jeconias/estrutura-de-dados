package classes.grafo;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import exceptions.TableIndexException;
import exceptions.JokerTypeNotFound;

public class Grafo {

    private Aresta[][] container;
    private Map<String, Vertice> vertices = new HashMap<String, Vertice>();
    private Map<String, Aresta> arestas = new HashMap<String, Aresta>();
    private int size = 0;

    public Grafo() {
        this.container = new Aresta[0][0];
    }

    public Vertice setVertice(Object v) {

        Aresta[][] tempTable = new Aresta[(this.size + 1)][(this.size + 1)];

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                tempTable[i][j] = this.container[i][j];
            }
        }

        Vertice vertice = new Vertice(v);
        vertice.setKey(String.format("v%d", this.vertices.size()));

        this.vertices.put(vertice.getKey(), vertice);
        this.container = tempTable;
        this.size = this.vertices.size();

        return vertice;
    }

    /**
     * Esse método adiciona uma aresta de acordo com o número da linha e coluna.
     * 
     * @param row Vertice da linha
     * @param col Vertice da coluna
     * @return Grafo
     * @throws TableIndexException
     */
    public Grafo setAresta(int row, String joker, int col) throws TableIndexException, JokerTypeNotFound {
        if (row >= this.size || col >= this.size || row < 0 || col < 0) {
            throw new TableIndexException("Coluna ou Linha maior que o limite da tabela");
        }

        Vertice a = this.vertices.get(String.format("v%d", row));
        Vertice b = this.vertices.get(String.format("v%d", col));

        Aresta aresta = new Aresta(a, b);
        aresta.setKey(String.format("a%d", this.arestas.size()));
        this.arestas.put(aresta.getKey(), aresta);

        switch (joker) {
        case "<>":
            aresta.addAnyDirection();
            break;
        case ">":
            aresta.addOneDirection(a);
            break;
        case "<":
            aresta.addOneDirection(b);
            break;
        default:
            throw new JokerTypeNotFound("Joker não encontrado.");
        }

        this.container[row][col] = aresta;
        return this;
    }

    public Object removeVertice(Vertice vertice) {
        Object tmp = vertice.getValue();
        ArrayList<Aresta> arestas = vertice.getArestas();

        for (int i = 0; i < arestas.size(); i++) {
            arestas.get(i).removeFromVertices();
            // this.arestas.remove(arestas.get(i).getKey());
        }

        Aresta[][] tempTable = new Aresta[(this.size - 1)][(this.size - 1)];

        for (int i = 0, ii = 0; i < this.size; i++, ii++) {
            if (vertice.getKey().equals(String.format("v%d", i))) {
                ii--;
                continue;
            }
            for (int j = 0, jj = 0; j < this.size; j++, jj++) {
                if (vertice.getKey().equals(String.format("v%d", j))) {
                    jj--;
                    continue;
                }
                tempTable[ii][jj] = this.container[i][j];
            }
        }
        this.vertices.remove(vertice.getKey());
        this.container = tempTable;
        this.size = this.vertices.size();
        return tmp;
    }

    /**
     * Retorna os vertices final da aresta.
     * 
     * @param a
     * @return
     * 
     * @TODO
     */
    public ArrayList<Vertice> finalVertices(Aresta a) {
        return new ArrayList<Vertice>();
    }

    /**
     * Substitui o elemento armazenado no vértice a por b
     * 
     * @param a
     * @param b
     * @return
     */
    public Grafo replace(Vertice a, Object b) {
        a.setValue(b);
        return this;
    }

    public int size() {
        return this.size;
    }

    public Grafo showTable() {
        String cols = "   ";
        String rows = "";

        for (int i = 0; i < this.size; i++) {
            cols += String.format(" V%d ", i);
            rows += String.format(" V%d ", i);

            for (int j = 0; j < this.size; j++) {
                if (this.container[i][j] == null) {
                    rows += " x  ";
                } else {
                    rows += String.format(" %s ", this.container[i][j].getJoker());
                }

            }
            rows += "\n";
        }

        System.out.print(String.format("%s\n%s", cols, rows));

        return this;
    }

}