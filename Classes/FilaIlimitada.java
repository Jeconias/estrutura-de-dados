package classes;

import interfaces.InterfaceFilaIlimitada;
import exceptions.*;

public class FilaIlimitada implements InterfaceFilaIlimitada {


    private int [] database;

    private int inicio = 0;
    private int fim = 0;
    private int tamanho = 0;

    public FilaIlimitada()
    {
        this.database = new int[2];
    }
 
    public void enfileirar(int value)
    {   
        // VERIFICANDO SE O ARRAY ESTA CHEIO
        if(this.tamanho() == (this.database.length - 1)) {
            
            int [] databaseTemp = new int[this.database.length * 2];
            int i, j;

            // PASSANDO TODOS OS VALORES PARA O NOVO ARRAY
            for(i = this.inicio, j = 0; i != this.fim; i = (i + 1) % this.database.length, j++){
                databaseTemp[j] = this.database[i];
            }

            // SETANDO O NOVO VALOR
            databaseTemp[j] = value;

            // APONTANDO PARA O NOVO ARRAY
            this.database = databaseTemp;

            // RESETANDO OS VALORES E SETANDO UM NOVO FIM
            this.inicio = 0;
            this.fim = j+1;

            return;
        }

        // ADICIONANDO O VALOR NO FINAL DO ARRAY
        this.database[this.fim] = value;

        // INCLEMENTANDO O VALOR DA VARIAVEL fim
        this.fim = (this.fim + 1) % this.database.length;
    }

    public int desenfileirar() throws FilaVaziaException
    {
        if(this.estaVazia()) throw new FilaVaziaException("Fila Vazia");

        // PEGAR O VALOR DO INICIO DA FILA
        int intTemp = this.database[this.inicio];

        // AVANÇANDO O inicio EM 1
        this.inicio = (this.inicio + 1) % this.database.length;

        return intTemp;
    }

    public int inicio()
    {
        return this.database[this.inicio];
    }

    public int tamanho()    
    {
        return (this.database.length - this.inicio + this.fim) % this.database.length;
    }

    public boolean estaVazia()
    {
        return (this.inicio == this.fim) ? true : false;
    }

}