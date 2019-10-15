package classes.grafo;

public class Aresta {

    private Vertice a = null;
    private Vertice b = null;
    private Boolean biDirection;
    private String joker = "^";
    private String key;

    public Aresta(Vertice a, Vertice b, boolean biDirection) {
        this.a = a;
        this.b = b;
        this.biDirection = biDirection;
        this.a.setAresta(this);
        this.b.setAresta(this);
        this.start();
    }

    public String getJoker() {
        return this.joker;
    }

    public Aresta addAutoRef(String joker) {
        this.joker = joker;
        this.a.setTarget(a);
        this.a.setArrow(a);
        return this;
    }

    public Aresta addAnyDirection() {
        this.a.setTarget(this.b);
        this.b.setArrow(this.a);

        this.b.setTarget(this.a);
        this.a.setArrow(this.b);
        return this;
    }

    public Aresta addOneDirection() {
        this.a.setTarget(this.b);
        this.b.setArrow(this.a);
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

    private void start(){
        if(this.a == this.b && this.biDirection == false){
            this.addAutoRef("o");
        }else if(this.a == this.b && this.biDirection == true){
            this.addAutoRef("|o|");
        }else if(this.a != this.b && this.biDirection == true) {
            this.addAnyDirection();
        }else{
            this.addOneDirection();
        }
    }

}