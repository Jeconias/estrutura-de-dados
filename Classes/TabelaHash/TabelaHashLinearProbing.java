package Classes.TabelaHash;

import Exceptions.NenhumElementoException;
import Exceptions.TabelaHashCheiaException;
import java.util.ArrayList;

public class TabelaHashLinearProbing {

    private No [] list = new No[14];
    private int size = 0;

    public TabelaHashLinearProbing(){}

    public int insertItem(int k, Object o) throws TabelaHashCheiaException
    {
        if(this.size == this.list.length) this.resize();

        int index = this.dispersal(k);
        int i = index;
        
        No noTmp = this.list[ index ];
        No no = new No();
        no.setChave(k);
        no.setValor(o);

        while(noTmp != null)
        {
            i = (i + 1) % this.list.length;
            noTmp = this.list[i];
            if(i == index) throw new TabelaHashCheiaException("FULL_TABLE");
        }

        this.list[i] = no;
        this.size++;
        return index;
    }

    public Object removeElement(int k) throws NenhumElementoException
    {
        int index = this.dispersal(k);
        int i = index;
        No noTmp = this.list[index];
        Object objTmp = null;

        objTmp = (this.list[index] != null && this.list[index].getChave() == k) ? this.list[i].getValor() : null;

        if(objTmp != null)
        {
            this.list[index] = null;
            return objTmp;
        }

        while(true)
        {
            i = (i + 1) % this.list.length;
            noTmp = this.list[i];
            if(noTmp != null && noTmp.getChave() == k)
            {
                objTmp = this.list[i].getValor();
                this.list[i] = null;
                break;
            }
            if(i == index) throw new NenhumElementoException("NO_SUCH_KEY");
        }
        return objTmp;
    }

    public No findElement(int k) throws NenhumElementoException
    {      
        int index = this.dispersal(k);
        int i = index;
        No noTmp = this.list[ index ];

        noTmp = (this.list[index] != null && this.list[index].getChave() == k) ? this.list[i] : null;
        
        if(noTmp != null) return this.list[index];
        
        while(true)
        {
            i = (i + 1) % this.list.length;
            noTmp = this.list[i];

            if(noTmp != null && noTmp.getChave() == k) {
                noTmp = this.list[i];
                break;
            }
            if(i == index) throw new NenhumElementoException("NO_SUCH_KEY");
        }
        return noTmp;
    }

    public ArrayList<Integer> keys()
    {
        int listSize = this.list.length;
        ArrayList<Integer> chaves = new ArrayList<Integer>();
        
        for(int i = 0; i < listSize; i++)
        {
            if(this.list[i] != null)
            {
                chaves.add(this.list[i].getChave());
            }
        }
        return chaves;
    }

    public ArrayList<No> elements()
    {
        ArrayList<No> nos = new ArrayList<No>();
        ArrayList<Integer> keys = this.keys();
        int keysSize = keys.size();

        for(int i = 0; i < keysSize; i++)
        {
            try
            {
                nos.add( this.findElement( keys.get(i) ) );
            }
            catch(NenhumElementoException e)
            {
                continue;
            }
        }
        return nos;
    }

    private void resize()
    {
        ArrayList<No> nos = this.elements();
        int sizeNos = nos.size();

        this.list = new No[ this.list.length * 2 ];

        for(int i = 0; i < sizeNos; i++)
        {
            try
            {
                this.insertItem( nos.get(i).getChave(), nos.get(i).getValor() );
            }
            catch(TabelaHashCheiaException e)
            {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    private int dispersal(int k)
    {
        return k % this.list.length;
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty()
    {
        return (this.size() != 0) ? false : true;
    }
}
