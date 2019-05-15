import Classes.Fila.Array.*;
import Classes.Fila.Lista.*;
import Classes.Lista.*;
import Classes.Pilha.Array.*;
import Classes.Pilha.Lista.*;
import Classes.Sequencia.Lista.*;
import Classes.Vector.Array.*;
import Classes.Arvore.Binaria.*;
import Classes.TabelaHash.*;
import Exceptions.*;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Main {

  public static void main (String args[])
  {

    // TAD FILA COM ARRAY
    FilaIlimitada FilaIlimitada = new FilaIlimitada();

    // TAD FILA COM LISTA SIMPLES ENCADEADA
    FilaIlimitadaLSE FilaIlimitadaLSE = new FilaIlimitadaLSE();

    // TAD LISTA COM LISTA DUPLAMENTE ENCADEADA
    TADListaDuplamenteEncadeada TADListaDuplamenteEncadeada = new TADListaDuplamenteEncadeada();

    // TAD PILHA COM ARRAY
    PilhaLimitada PilhaLimitada = new PilhaLimitada(10);

    // TAD PILHA COM ARRAY
    PilhaIlimitada PilhaIlimitada = new PilhaIlimitada(10);

    // TAD PILHA COM ARRAY (PILHA RUBRO)
    PilhaIlimitadaVP PilhaIlimitadaVP = new PilhaIlimitadaVP(10);

    // TAD SEQUENCIA COM LISTA DUPLAMENTE LIGADA
    TADSequenciaLDE TADSequenciaLDE = new TADSequenciaLDE();

    // TAD VECTOR COM ARRAY
    TADVector TADVector = new TADVector();

    // ARVORE BINARIA
    ArvoreBinaria ArvB = new ArvoreBinaria();

    // TABELA HASH
    TabelaHashEncadeamento TabelaHashEncadeamento = new TabelaHashEncadeamento();


    // ### TESTES PARA A TABELA HASH COM ENCADEADA ###

    TabelaHashEncadeamento.insertItem(15, "a");
    TabelaHashEncadeamento.insertItem(21, "b");
    TabelaHashEncadeamento.insertItem(10, "c");
    //TabelaHashEncadeamento.insertItem(31, "d");
    //TabelaHashEncadeamento.insertItem(25, "Test");
    //TabelaHashEncadeamento.insertItem(5, "cinco");

    
    //TabelaHashEncadeamento.removeElement(25);

    //System.out.println(TabelaHashEncadeamento.search(25));
    try
    {
      //TabelaHashEncadeamento.removeElement(15);
      System.out.println( TabelaHashEncadeamento.findElement(21).getValor() );
    }
      catch(NenhumElementoException e)
    {
      System.out.println( e.getMessage() );
    }


    ArrayList<Classes.TabelaHash.No> nos = TabelaHashEncadeamento.elements();

    //System.out.println( nos.get(0).getValor() );
    //System.out.println( nos.get(1).getValor() );
    //System.out.println( nos.get(2).getValor() );
    //System.out.println( nos.get(3).getValor() );
    //System.out.println( nos.get(4).getValor() );

    //System.out.println( TabelaHashEncadeamento.size() );

  }
}
