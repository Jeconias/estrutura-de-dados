package classes.grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

    Object value = null;
    String key;
    Boolean isVisited = false;

    /**
     * Meu alvos / Para aonde eu posso ir
     */
    private ArrayList<Vertice> targets = new ArrayList<Vertice>();

    /**
     * Sou alvo / Quem pode chegar até mim
     */
    private ArrayList<Vertice> arrows = new ArrayList<Vertice>();

    /**
     * Arestas que o Vertice possui
     */
    private ArrayList<Aresta> arestas = new ArrayList<Aresta>();

    public Vertice(Object v) {
        this.value = v;
    }

    public Object getValue() {
        return this.value;
    }

    public Vertice setValue(Object v) {
        this.value = v;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<Aresta> getArestas() {
        ArrayList<Aresta> clones = new ArrayList<Aresta>();
        this.arestas.forEach(a -> clones.add(a));
        return clones;
    }

    public Vertice setAresta(Aresta aresta) {
        if (this.arestas.indexOf(aresta) != -1)
            return this;
        this.arestas.add(aresta);
        return this;
    }

    public Vertice setTarget(Vertice v) {
        this.targets.add(v);
        return this;
    }

    public ArrayList<Vertice> getTargets() {
        return this.targets;
    }

    public Vertice setArrow(Vertice v) {
        this.arrows.add(v);
        return this;
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

    public String toString() {
        String str = String.format("\n### %s ###\nTargets: ", this.getKey());

        for (Vertice curr : this.targets) {
            str += String.format("%s ", curr.getKey());
        }

        str += String.format("\nArrows: ");
        for (Vertice curr : this.arrows) {
            str += String.format("%s ", curr.getKey());
        }

        str += String.format("\nArestas: ");
        for (Aresta curr : this.arestas) {
            str += String.format("%s ", curr.getKey());
        }

        return str;
    }

}