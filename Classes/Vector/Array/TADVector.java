package Classes.Vector.Array;

import Exceptions.TADVectorException;
import Interfaces.InterfaceTADVector;

public class TADVector implements InterfaceTADVector {

    private int [] vector;
    private int size = 0;

    public TADVector()
    {
        this.vector = new int[5];
    }

    public int elemAtRank(int v) throws TADVectorException
    {
        if(this.validateIndex(v) != true) throw new TADVectorException("Colocação não existente");
        return this.vector[v];
    }

    public int replaceAtRank(int v, int o) throws TADVectorException
    {
        if(this.validateIndex(v) != true) throw new TADVectorException("Colocação não existente");

        int intTemp = this.vector[v];
        this.vector[v] = o;
        return intTemp;
    }

    public void insertAtRank(int v, int o)
    {
        // VERIFICAR SE O VECTOR CHEGOU NO LIMITE
        if(this.size == this.vector.length)
        {
            int [] vectorTemp = new int[this.vector.length * 2];

            for(int i = 0; i < this.vector.length; i++)
            {
                vectorTemp[i] = this.vector[i];
            }
            this.vector = vectorTemp;
        }

        // INSERIR O VALOR NA POSICAO DESEJADA
        int i = (this.vector.length-1);
        while(i > v)
        {
            this.vector[i] = this.vector[i-1];
            i--;
        }
        this.vector[v] = o;
        this.size++;
    }

    public int removeAtRank(int v) throws TADVectorException
    {
        if(this.validateIndex(v) != true) throw new TADVectorException("Colocação não existente");

        int intTemp = this.vector[v];

        // DESLOCAR PARA A ESQUERDA
       for(int i = v; i < (this.vector.length - 1); i++)
       {
            this.vector[i] = this.vector[i+1];
            this.vector[i+1] = 0;
       }

       this.size--;
        return intTemp;
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    private boolean validateIndex(int v)
    {
        return (v < 0 || v > (this.vector.length - 1)) ? false : true;
    }

}
