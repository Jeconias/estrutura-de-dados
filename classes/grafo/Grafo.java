package classes.grafo;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import exceptions.TableIndexException;

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
     * @return Aresta
     * @throws TableIndexException
     */
    public Aresta setAresta(int row, int col, boolean biDirection) throws TableIndexException {
        if (row >= this.size || col >= this.size || row < 0 || col < 0) {
            throw new TableIndexException("Coluna ou Linha maior que o limite da tabela");
        }

        Vertice a = this.vertices.get(String.format("v%d", row));
        Vertice b = this.vertices.get(String.format("v%d", col));

        Aresta aresta = new Aresta(a, b, biDirection);
        aresta.setKey(String.format("a%d", this.arestas.size()));
        this.arestas.put(aresta.getKey(), aresta);

        if (biDirection == true) {
            this.container[col][row] = aresta;
        }
        this.container[row][col] = aresta;
        return aresta;
    }

    public Object removeVertice(Vertice vertice) {
        Object tmp = vertice.getValue();
        ArrayList<Aresta> arestas = vertice.getArestas();

        arestas.forEach((a) -> {
            this.arestas.remove(a.getKey());
            a.removeFromVertices();
        });

        if ((this.size - 1) == 0) {
            this.vertices.remove(vertice.getKey());
            this.size = this.vertices.size();
            return null;
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

    public ArrayList<Vertice> removeAresta(Aresta arst) {
        ArrayList<Vertice> vsrts = new ArrayList<Vertice>();
        vsrts.add(arst.getVerticeA());
        vsrts.add(arst.getVerticeB());

        int row = Integer.parseInt(arst.getVerticeA().getKey().substring(1, 2));
        int col = Integer.parseInt(arst.getVerticeB().getKey().substring(1, 2));
        this.container[row][col] = null;
        this.arestas.remove(arst.getKey());
        arst.removeFromVertices();
        return vsrts;
    }

    /**
     * Retorna os vertices finais da aresta.
     * 
     * @param a
     * @return
     * 
     * @TODO
     */
    public ArrayList<Vertice> finalVertices(Aresta a) {
        ArrayList<Vertice> vFinals = new ArrayList<Vertice>();
        vFinals.add(a.getVerticeB());
        return vFinals;
    }

    /**
     * Retorna true se a e b são adjacentes
     * 
     * @param a
     * @param b
     * @return boolean
     */
    public boolean isAdjacent(Vertice a, Vertice b) {
        for (Aresta arst : a.getArestas()) {
            if (b.getArestas().indexOf(arst) != -1)
                return true;
        }
        return false;
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

    public boolean isBiDirection(Aresta a) {
        return a.isBiDirection();
    }

    public String dfs(String key) {
        key = String.format("v%s", key);
        if (!this.vertices.containsKey(key)) {
            // TODO(Jeconias): Adicionar exceção
            return "Vertice não existe";
        }
        return this.depthFirstSearch(key);
    }

    private String depthFirstSearch(String key) {
        String r = "";
        Vertice current = this.vertices.get(key);
        current.setIsVisited(true);
        r += String.format("%s ", current.getKey());

        for (Map.Entry<String, Vertice> v : this.vertices.entrySet()) {
            if (this.isAdjacent(current, v.getValue())) {
                if (!v.getValue().isVisited()) {
                    r += this.depthFirstSearch(v.getKey());
                }
            }
        }
        return r;
    }

    public Grafo showTable() {
        String cols = "   ", rows = "", joker = "";

        for (int i = 0; i < this.size; i++) {
            cols += String.format(" V%d", i);
            rows += String.format(" V%d", i);

            for (int j = 0; j < this.size; j++) {
                if (this.container[i][j] == null) {
                    rows += " x ";
                } else {
                    joker = this.container[i][j].getJoker();
                    if (joker.equals("^") || joker.equals("o")) {
                        rows += String.format(" %s ", this.container[i][j].getJoker());
                    } else {
                        rows += String.format("%s ", this.container[i][j].getJoker());
                    }

                }

            }
            rows += "\n";
        }

        System.out.print(String.format("%s\n%s", cols, rows));

        return this;
    }

    public String arestasToString() {
        String str = "";
        for (Map.Entry<String, Aresta> aresta : this.arestas.entrySet()) {
            str += String.format("%s\n", aresta.getValue().arestaToString());
        }
        return str;
    }

}