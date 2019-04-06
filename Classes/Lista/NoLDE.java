package Classes.Lista;

public class NoLDE {

    private NoLDE before = null;
    private NoLDE after = null; 
    private int value;

    public NoLDE(NoLDE before, NoLDE after, int value) {
        this.before = before;
        this.after = after;
        this.value = value;
    }

    public NoLDE getBefore()
    {
        return this.before;
    }

    public void setBefore(NoLDE before)
    {
        this.before = before;
    }

    

    public NoLDE getAfter()
    {
        return this.after;
    }

    public void setAfter(NoLDE after)
    {
        this.after = after;
    }


    public int getValue()
    {
        return this.value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }


}