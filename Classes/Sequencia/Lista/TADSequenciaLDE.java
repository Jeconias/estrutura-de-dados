package Classes.Sequencia.Lista;

import Exceptions.TADVectorException;
import Classes.Lista.NoLDE;

public class TADSequenciaLDE {

    private NoLDE noFirst = new NoLDE(null, null, 0);
    private NoLDE noLast = new NoLDE(null, null, 0);
    private int size = 0;

    public TADSequenciaLDE()
    {
        this.noFirst.setAfter(this.noLast);
        this.noLast.setBefore(this.noFirst);
    }

    public NoLDE first()
    {
        return this.noFirst.getAfter();
    }

    public NoLDE last()
    {
        return this.noLast.getBefore();
    }

    public NoLDE before(NoLDE n)
    {
        return n.getBefore();
    }

    public NoLDE after(NoLDE n)
    {
        return n.getAfter();
    }

    public NoLDE insertFirst(int n)
    {
        NoLDE noTemp = new NoLDE(this.noFirst, this.noFirst.getAfter(), n);
        this.noFirst.getAfter().setBefore(noTemp);
        this.noFirst.setAfter(noTemp);
        this.size++;
        return noTemp;
    }

    public NoLDE insertLast(int n)
    {
        NoLDE noTemp = new NoLDE(this.noLast.getBefore(), this.noLast, n);
        this.noLast.getBefore().setAfter(noTemp);
        this.noLast.setBefore(noTemp);
        this.size++;
        return noTemp;
    }

    public NoLDE insertAfter(int n, NoLDE o)
    {
        NoLDE noTemp = new NoLDE(o, o.getAfter(), n);
        o.getAfter().setBefore(noTemp);
        o.setAfter(noTemp);
        this.size++;
        return noTemp;
    }

    public NoLDE insertBefore(int n, NoLDE o)
    {
        NoLDE noTemp = new NoLDE(o.getBefore(), o, n);
        o.getBefore().setAfter(noTemp);
        o.setBefore(noTemp);
        this.size++;
        return noTemp;
    }

    public void swapElements(NoLDE n, NoLDE o)
    {
        int x = n.getValue();
        n.setValue(o.getValue());
        o.setValue(x);
    }

    public void replaceElement(NoLDE n, NoLDE o)
    {
        o.setValue(n.getValue());
    }

    public boolean isFirst(NoLDE n)
    {
        return (n.getBefore().getBefore() != null) ? false : true;
    }

    public boolean isLast(NoLDE n)
    {
        return (n.getAfter().getAfter() != null) ? false : true;
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty()
    {
        return (this.size != 0) ? false : true;
    }

    public void remove(NoLDE n)
    {
        n.getBefore().setAfter(n.getAfter());
        n.getAfter().setBefore(n.getBefore());
        n.setAfter(null);
        n.setBefore(null);
        this.size--;
    }

    // METODOS DO VECTOR

    public int elemAtRank(int v) throws TADVectorException
    {
        if(this.validateIndex(v) != true) throw new TADVectorException("Colocação não existente");
        return this.AtRank(v).getValue();
    }

    public int replaceAtRank(int v, int o) throws TADVectorException
    {
        if(this.validateIndex(v) != true) throw new TADVectorException("Colocação não existente");

        NoLDE noTemp = this.AtRank(v);
        int intTemp = noTemp.getValue();

        noTemp.setValue(o);
        return intTemp;
    }

    public void insertAtRank(int v, int o)
    {
        NoLDE noTemp = this.AtRank(v);
        this.insertBefore(o, noTemp);
    }

    public NoLDE AtRank(int rank) {
        NoLDE node;
        if (rank <= this.size/2) {

         node = this.noFirst.getAfter();
         for(int i=0; i < rank; i++){
            node = node.getAfter();
         }
           
        }else{

        node = this.noLast.getBefore();
        for(int i=0; i < (this.size - rank) - 1 ; i++)
            node = node.getBefore();
        }
        return node;
    }

    public int rankOf(NoLDE no) {
        NoLDE n = this.noFirst.getAfter();
        int r = 0;
        while(n != no && n != this.noLast) {
            n = n.getAfter();
            r++;
        }
        return r;
    }

    public int removeAtRank(int v) throws TADVectorException
    {
        if(this.validateIndex(v) != true) throw new TADVectorException("Colocação não existente");

        NoLDE noTemp = this.AtRank(v);
        int intTemp = noTemp.getValue();

        this.remove(noTemp);
        
        return intTemp;
    }


    private boolean validateIndex(int v)
    {
        return (v < 0 || v > this.size) ? false : true;
    }
}
