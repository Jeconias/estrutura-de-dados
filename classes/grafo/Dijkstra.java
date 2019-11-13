package classes.grafo;

public class Dijkstra {
    private Vertice from = null;
    private Object custo = Integer.MAX_VALUE;

    public Dijkstra() {
    }

    public Dijkstra(Vertice from, Object custo) {
        this.from = from;
        this.custo = custo;
    }

    public Vertice getFrom() {
        return this.from;
    }

    public Dijkstra setFrom(Vertice from) {
        this.from = from;
        return this;
    }

    public Object getCusto() {
        return this.custo;
    }

    public Dijkstra setCusto(Object custo) {
        this.custo = custo;
        return this;
    }
}