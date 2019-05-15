package Classes.TabelaHash;

import Exceptions.NenhumElementoException;
import java.util.ArrayList;

public class TabelaHashEncadeamento {

    private No [] list = new No[10];
    private int size = 0;

    public TabelaHashEncadeamento(){}

    public int insertItem(int k, Object o)
    {
        int index = this.dispersal(k);

        No no = new No();
        no.setChave(k);
        no.setValor(o);
        
        if(this.list[index] == null) 
        {
            this.list[index] = no;
            this.size++;
            return index;
        }

        No noTmp = this.list[index];
        while(noTmp.getProximo() != null)
        {
            noTmp = noTmp.getProximo();
        }

        noTmp.setProximo(no);
        this.size++;
        return index;
    }

    public Object removeElement(int k) throws NenhumElementoException
    {
        int index = this.dispersal(k);
        Object objTmp;

        if(this.list[index] != null && this.list[index].getChave() == k)
        {   
            objTmp = this.list[index].getValor();
            this.list[index] = (this.list[index].getProximo() == null) ? null : this.list[index].getProximo();
            this.size--;
            return objTmp;
        }else if(this.list[index] == null){
            throw new NenhumElementoException("NO_SUCH_KEY");
        }
        
        No noTmp = this.list[index];
        while(noTmp.getProximo() != null && noTmp.getProximo().getChave() != k)
        {
            noTmp = noTmp.getProximo();
        }

        if(noTmp.getProximo() == null) throw new NenhumElementoException("NO_SUCH_KEY");;

        No noRemoveTmp = noTmp.getProximo();
        objTmp = noRemoveTmp.getValor();

        noTmp.setProximo(noRemoveTmp.getProximo());
        
        noRemoveTmp = null;
        this.size--;
        return objTmp;
    }

    public No findElement(int k) throws NenhumElementoException
    {      
        int index = this.dispersal(k);
        No noTmp = this.list[ index ];

        while(noTmp != null && noTmp.getChave() != k)
        {
            noTmp = noTmp.getProximo();
        }

        if(noTmp != null) return noTmp;
        throw new NenhumElementoException("NO_SUCH_KEY");
    }

    public ArrayList<Integer> keys()
    {
        int listSize = this.list.length;
        No noTmp;
        ArrayList<Integer> chaves = new ArrayList();
        
        for(int i = 0; i < listSize; i++)
        {
            if(this.list[i] != null)
            {
                noTmp = this.list[i];
                while(noTmp != null)
                {
                    chaves.add(noTmp.getChave());
                    noTmp = noTmp.getProximo();
                }
            }
        }
        return chaves;
    }

    public ArrayList<No> elements()
    {
        ArrayList<No> nos = new ArrayList();
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
