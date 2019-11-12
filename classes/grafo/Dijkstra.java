package classes.grafo;

public class Dijkstra {
    private boolean isOpen = true;
    private Vertice from = null;
    private Object custo = Integer.MAX_VALUE;

    public Dijkstra() {
    }

    public Dijkstra(boolean isOpen, Vertice from, Object custo) {
        this.isOpen = isOpen;
        this.from = from;
        this.custo = custo;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public Dijkstra setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
        return this;
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