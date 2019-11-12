package classes.grafo;

import java.util.ArrayList;

public class Vertice {

    private ArrayList<Aresta> arestas = new ArrayList<Aresta>();
    private Dijkstra dijkstra = new Dijkstra();
    private Object element;
    private Boolean isVisited = false;

    public Vertice(Object o) {
        this.element = o;
    }

    public Dijkstra getDijkstra() {
        return this.dijkstra;
    }

    public ArrayList<Aresta> getArestas() {
        return this.arestas;
    }

    public Vertice setAresta(Aresta aresta) {
        if (this.arestas.indexOf(aresta) != -1)
            return this;
        this.arestas.add(aresta);
        return this;
    }

    public Object getElement() {
        return this.element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Boolean removeAresta(Aresta aresta) {
        return this.arestas.remove(aresta);
    }

    public boolean isVisited() {
        return this.isVisited;
    }

    public void setIsVisited(boolean v) {
        this.isVisited = v;
    }

}