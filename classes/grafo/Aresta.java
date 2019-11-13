package classes.grafo;

public class Aresta {

    private Vertice a = null;
    private Vertice b = null;
    private Boolean biDirection;
    private Object custo;
    private String key;
    private Boolean open = true;

    public Aresta(Vertice a, Vertice b, boolean biDirection) {
        this.a = a;
        this.b = b;
        this.biDirection = biDirection;
        this.a.setAresta(this);
        this.b.setAresta(this);
    }

    public Vertice getA() {
        return this.a;
    }

    public void setA(Vertice a) {
        this.a = a;
    }

    public Vertice getB() {
        return this.b;
    }

    public void setB(Vertice b) {
        this.b = b;
    }

    public Boolean isBiDirection() {
        return this.biDirection;
    }

    public Boolean getBiDirection() {
        return this.biDirection;
    }

    public void setBiDirection(Boolean biDirection) {
        this.biDirection = biDirection;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getCusto() {
        return this.custo;
    }

    public void setCusto(Object custo) {
        this.custo = custo;
    }

    public void removeFromVertices() {
        this.a.removeAresta(this);
        this.b.removeAresta(this);
    }

    public boolean hasVertice(Vertice x) {
        if (this.a == x || this.b == x)
            return true;
        return false;
    }

    public Vertice getInverseVertice(Vertice v) {
        return this.a == v ? this.b : this.a;
    }

    public Boolean isOpen() {
        return this.open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

}