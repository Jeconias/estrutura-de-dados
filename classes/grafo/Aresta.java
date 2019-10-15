package classes.grafo;

public class Aresta {

    private Vertice a = null;
    private Vertice b = null;
    private String joker = "";
    private String key;

    public Aresta(Vertice a, Vertice b) {
        this.a = a;
        this.b = b;
        this.a.setAresta(this);
        this.b.setAresta(this);
    }

    public String getJoker() {
        return this.joker;
    }

    public Aresta addAnyDirection() {
        this.joker = "<>";

        this.a.setTarget(this.b);
        this.a.setArrow(this.b);

        this.b.setTarget(this.a);
        this.b.setArrow(this.a);
        return this;
    }

    public Aresta addOneDirection(Vertice target) {
        if (target == this.a) {

            this.joker = ">";
            this.a.setTarget(this.b);
            this.b.setArrow(this.a);

        } else if (target == this.b) {

            this.joker = "<";
            this.b.setTarget(this.a);
            this.a.setArrow(this.b);

        }
        return this;
    }

    public void removeFromVertices() {
        this.a.removeAresta(this);
        this.b.removeAresta(this);
    }

    public Aresta setKey(String key) {
        this.key = key;
        return this;
    }

    public String getKey() {
        return this.key;
    }

}