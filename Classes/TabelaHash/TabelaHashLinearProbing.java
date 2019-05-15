package Classes.TabelaHash;

public class TabelaHashLinearProbing {

    private int [] list = new int[14];

    public TabelaHashLinearProbing(){}

    public int insert(int k)
    {
        int index = this.dispersal(k);
        if(this.list[index] == 0) 
        {
            this.list[index] = k;
            return index;
        }

        for(int i = index; i != (index - 1); i = (i + 1) % this.list.length)
        {
            if(this.list[i] == 0)
            {
                this.list[i] = k;
                return i;
            }
        }
        return -1;
    }

    public int search(int k)
    {
        int index = this.dispersal(k);
        int i = index;
        while(i != (index - 1))
        {
            if(this.list[i] == 0) return -1;
            if(this.list[i] == k) return i;
            i = ((i + 1) % this.list.length); 
        }
        return -1;
    }



    private int dispersal(int k)
    {
        return k % (this.list.length - 1);
    }


}
