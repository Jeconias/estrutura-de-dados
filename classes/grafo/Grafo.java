package classes.grafo;

import java.util.ArrayList;

import exceptions.TableIndexException;

public class Grafo {

    private ArestaContainer[][] grafo;
    private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
    private ArrayList<Aresta> arestas = new ArrayList<Aresta>();

    public Grafo() {
        this.grafo = new ArestaContainer[0][0];
    }

    public Vertice newVertice(Object o) {
        return new Vertice(o);
    }

    public Grafo setVertices(Vertice... o) {
        int sizeObject = o.length, zo = 0;
        ArestaContainer[][] tmpAC = new ArestaContainer[(this.vertices.size() + sizeObject)][(this.vertices.size()
                + sizeObject)];

        for (int i = 0; i < this.vertices.size(); i++) {
            for (int j = 0; j < this.vertices.size(); j++) {
                tmpAC[i][j] = this.grafo[i][j];
            }
        }

        Vertice v;
        while (zo < sizeObject) {
            v = o[zo];
            this.vertices.add(v);
            zo++;
        }

        this.grafo = tmpAC;
        return this;
    }

    public Aresta setAresta(int row, int col, boolean biDirection) throws TableIndexException {
        if (row >= this.vertices.size() || col >= this.vertices.size() || row < 0 || col < 0) {
            throw new TableIndexException("Coluna ou Linha maior que o limite da tabela.");
        }

        if (biDirection && this.grafo[col][row] == null) {
            this.grafo[col][row] = new ArestaContainer();
        }

        if (this.grafo[row][col] == null) {
            this.grafo[row][col] = new ArestaContainer();
        }

        Vertice a = this.findVertice(row);
        Vertice b = this.findVertice(col);

        Aresta aresta = new Aresta(a, b, biDirection);
        aresta.setKey(String.format("a%d", this.arestas.size()));
        this.arestas.add(aresta);

        if (biDirection == true) {
            this.grafo[col][row].add(aresta);
        }
        this.grafo[row][col].add(aresta);
        return aresta;

    }

    // TODO(Jeconias): não finalizado.
    public Object removeVertice(Vertice vertice) {
        Object tmp = vertice.getElement();
        ArrayList<Aresta> arestas = new ArrayList<Aresta>(vertice.getArestas());

        System.out.println(vertice.getArestas().size());

        arestas.forEach((aresta) -> {
            this.arestas.remove(aresta);
            aresta.removeFromVertices();
        });

        if ((this.vertices.size() - 1) == 0) {
            this.vertices.remove(vertice);
            return tmp;
        }

        ArestaContainer[][] tmpAC = new ArestaContainer[(this.vertices.size() - 1)][(this.vertices.size() - 1)];
        for (int i = 0, ii = 0; i < this.vertices.size(); i++, ii++) {
            if (i == this.vertices.indexOf(vertice)) {
                ii--;
                continue;
            }
            for (int j = 0, jj = 0; j < this.vertices.size(); j++, jj++) {
                if (j == this.vertices.indexOf(vertice)) {
                    jj--;
                    continue;
                }
                tmpAC[ii][jj] = this.grafo[i][j];
            }
        }
        this.vertices.remove(vertice);
        this.grafo = tmpAC;
        return tmp;
    }

    public void carteiroChines() {
        ArrayList<Vertice> vImpares = this.vImpares();
        this.dijkstra(vImpares);

        for (int i = 0; i < vImpares.size(); i++) {
            for (int j = 0; j < (vImpares.size() + 1); j++) {
                // System.out.println(m[i][j]);
            }
        }

    }

    public void dijkstra(ArrayList<Vertice> vertices) {
        int vI = vertices.size();
        int countVertice = 0;
        Vertice init = vertices.get(0);
        Vertice tmp = new Vertice(-1);
        init.getDijkstra().setCusto(0);
        while (countVertice != vI) {

            for (int i = 0; i < init.getArestas().size(); i++) {
                Aresta a = init.getArestas().get(i);
                int total = ((int) init.getDijkstra().getCusto() + (int) a.getCusto());
                if (total < (int) tmp.getDijkstra().getCusto()) {
                    tmp = a.getInverseVertice(init);
                }

                if (total < (int) a.getInverseVertice(init).getDijkstra().getCusto()) {
                    a.getInverseVertice(init).getDijkstra().setCusto(total).setFrom(init);
                }
                System.out.print(tmp.getElement());
            }
            init = tmp;
            countVertice++;
        }

        // System.out.println(init.getElement());

    }

    public ArrayList<Vertice> vImpares() {
        ArrayList<Vertice> impares = new ArrayList<Vertice>();
        int grau = 0, soma = 0, f = 0, n = this.grafo.length;

        while (soma <= 2 && f < n) {
            grau = 0;
            for (int i = 0; i < n; i++) {
                grau += this.grafo[f][i] != null ? this.grafo[f][i].size() : 0;
            }
            if ((grau % 2) == 1) {
                impares.add(this.vertices.get(f));
            }
            f++;
        }
        return impares;
    }

    // Verificar se existe um caminho euleriano / Fleury
    public boolean isEule() {
        int grau = 0, soma = 0, f = 0, n = this.grafo.length;

        while (soma <= 2 && f < n) {
            grau = 0;
            for (int i = 0; i < n; i++) {
                grau += this.grafo[f][i] != null ? this.grafo[f][i].size() : 0;
            }
            if ((grau % 2) == 1) {
                soma++;
            }
            f++;
        }
        if (soma > 2)
            return false;
        return true;
    }

    public ArrayList<Vertice> dfs(Vertice v) {
        if (!this.vertices.contains(v)) {
            // TODO(Jeconias): Adicionar exceção
            return null;
        }
        ArrayList<Vertice> vs = new ArrayList<Vertice>();
        this.depthFirstSearch(v, vs);
        return vs;
    }

    private void depthFirstSearch(Vertice v, ArrayList<Vertice> vs) {
        vs.add(v);
        v.setIsVisited(true);
        int sz = this.vertices.size();
        for (int i = 0; i < sz; i++) {
            if (this.isAdjacent(v, this.vertices.get(i))) {
                if (!this.vertices.get(i).isVisited()) {
                    this.depthFirstSearch(this.vertices.get(i), vs);
                }
            }
        }
    }

    private Vertice findVertice(int k) {
        return vertices.get(k);
    }

    public boolean isAdjacent(Vertice a, Vertice b) {
        int row = this.vertices.indexOf(a);
        int col = this.vertices.indexOf(b);

        if (a == b)
            return true;

        if (this.grafo[row][col] == null && this.grafo[col][row] == null)
            return false;

        return true;
    }

    public Aresta getArestaAdjacent(Vertice a, Vertice b) {
        for (Aresta arst : a.getArestas()) {
            if (b.getArestas().indexOf(arst) != -1)
                return arst;
        }
        return null;
    }

    public int totalVertice() {
        return this.vertices.size();
    }

    public Grafo showGrafo(boolean d) {
        String cols = "   ", rows = "", arestaContainer = "";

        for (int i = 0; i < this.vertices.size(); i++) {
            cols += String.format(" V%s", i);
            rows += String.format(" V%s", i);
            for (int j = 0; j < this.vertices.size(); j++) {
                if (this.grafo[i][j] != null) {
                    rows += String.format(" %s ", this.grafo[i][j].size());
                    int sz = this.grafo[i][j].size();
                    arestaContainer += String.format("### Row %d x Col %d ###\n", i, j);
                    Aresta a;
                    while (sz != 0) {
                        a = this.grafo[i][j].get(sz - 1);
                        arestaContainer += String.format("%s == V%s %s V%s\n", a.getKey().toUpperCase(),
                                this.vertices.indexOf(a.getA()), a.getBiDirection() ? "<->" : "->",
                                this.vertices.indexOf(a.getA()));
                        sz--;
                    }
                    arestaContainer += "\n\n";
                } else {
                    rows += " 0 ";
                }

            }
            rows += "\n";
        }

        System.out.print(String.format("%s\n%s\n%s", cols, rows, d ? arestaContainer : ""));
        return this;
    }

}