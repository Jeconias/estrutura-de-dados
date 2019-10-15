package classes.grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

    Object value = null;
    String key;

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
        return this.arestas;
    }

    public Vertice setAresta(Aresta aresta) {
        this.arestas.add(aresta);
        return this;
    }

    public Vertice setTarget(Vertice v) {
        this.targets.add(v);
        return this;
    }

    public Vertice setArrow(Vertice v) {
        this.arrows.add(v);
        return this;
    }

    public Boolean removeAresta(Aresta aresta) {
        return this.arestas.remove(aresta);
    }

}