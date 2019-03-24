package Classes;

public class TADListaDuplamenteEncadeada {

    private NoLDE noFirst = new NoLDE(null, null, 0);
    private NoLDE noLast = new NoLDE(null, null, 0);
    private int size = 0;

    public TADListaDuplamenteEncadeada()
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
        o.setAfter(noTemp);
        this.size++;
        return noTemp;
    } 

    public NoLDE insertBefore(int n, NoLDE o)
    {
        NoLDE noTemp = new NoLDE(o.getBefore(), o, n);
        o.setBefore(noTemp);
        this.size++;
        return noTemp;
    } 

    public void swapElements(NoLDE n, NoLDE o)
    {
        NoLDE nBefore = n.getBefore();
        NoLDE nAfter = n.getAfter();

        n.setAfter(o.getAfter());
        n.getAfter().setBefore(n);
        n.setBefore(o.getBefore());
        n.getBefore().setAfter(n);

        o.setAfter(nAfter);
        o.setBefore(nBefore);
        nBefore.setAfter(o);
        nAfter.setBefore(o);
    }

    public void replaceElement(NoLDE n, NoLDE o)
    {
        o.setAfter(n.getAfter());
        o.setBefore(n.getBefore());

        o.getAfter().setBefore(o);
        o.getBefore().setAfter(o);
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
    }



}