package Classes.Pilha.Lista;

import Classes.Pilha.Lista.ListaSimplesEncadeada;
import Interfaces.InterfacePilhaIlimitadaLSE;
import Exceptions.PilhaVaziaException;

public class PilhaIlimitadaLSE implements InterfacePilhaIlimitadaLSE  {

    // ARMAZENA O TOPO DA PILHA (ULTIMO OBJ INSERIDO)
    private ListaSimplesEncadeada first = null;
    private int size = 0;

    public void push(int value)
    {
        if(this.first != null){
            // CRIANDO UM NOVO NÓ COM O PROXIMO NULO (ESSE NO SERA O ULTIMO (TOPO) OBJ NA PILHA)
            ListaSimplesEncadeada noTemp = new ListaSimplesEncadeada(value, null);

            // SETANDO O noTemp PARA O PRIMEIRO ELEMENTO DO NO
            noTemp.setNext(this.first);

            // first VAI APONTAR PARA O PRIMEIRO ELEMENTO DO NÓ
            this.first = noTemp;

            // INTEIRO Q REPRESENTA O TAMANHO DA PILHA
            this.size++;
            return;
        }

        // CRIANDO O OBJ INICIAL DA LL
        this.first = new ListaSimplesEncadeada(value, null);
        // INTEIRO Q REPRESENTA O TAMANHO DA PILHA
        this.size++;
    }

    public int pop() throws PilhaVaziaException {

        // VERIFICAR SE A PILHA ESTA VAZIA
        if(this.isEmpty() == true) throw new PilhaVaziaException("Pilha Vazia");

        // PEGANDO O VALOR DO ULTIMO OBJ INSERIDO
        int intTemp = this.first.getValue();

        // REMOVENDO O ULTIMO OBJ INSERIDO
        this.first = this.first.getNext();

        this.size--;
        return intTemp;
    }

    public int top() throws PilhaVaziaException {

        // VERIFICAR SE A PILHA ESTA VAZIA
        if(this.isEmpty() == true) throw new PilhaVaziaException("Pilha Vazia");

        // RETORNAR O ULTIMO VALOR INSERIDO
        return this.first.getValue();
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty()
    {
        return (this.first != null) ? false : true;
    }

}
