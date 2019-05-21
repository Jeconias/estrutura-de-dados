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

    TabelaHashLinearProbing TabelaHashLinearProbing = new TabelaHashLinearProbing();



    // ### TESTES PARA A TABELA HASH COM ENCADEADA ###

    try{
      TabelaHashLinearProbing.insertItem(18, "a");
      TabelaHashLinearProbing.insertItem(19, "d");
      TabelaHashLinearProbing.insertItem(18, "a");
      TabelaHashLinearProbing.insertItem(19, "a");
      TabelaHashLinearProbing.insertItem(18, "a");
    }catch(TabelaHashCheiaException e)
    {
      System.out.println(e.getMessage());
    }
    //TabelaHashEncadeamento.insertItem(25, "Test");
    //TabelaHashEncadeamento.insertItem(5, "cinco");

  }
}
