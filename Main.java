import Classes.Fila.Array.*;
import Classes.Fila.Lista.*;
import Classes.Lista.*;
import Classes.Ordenacao.*;
import Classes.Pilha.Array.*;
import Classes.Pilha.Lista.*;
import Classes.Sequencia.Lista.*;
import Classes.Vector.Array.*;
import Classes.Arvore.Binaria.*;
import Classes.TabelaHash.*;
import Exceptions.*;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;

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

      int [] intArr = new int[10001];
      int i = 0;
      // LER OS DADOS PARA REALIZAR OS TESTES
      try{
        BufferedReader br = new BufferedReader(new FileReader("./Ordenacao/teste_10000_1.dat"));
        
        while(br.ready())
        {
          String linha = br.readLine();
          intArr[i] = Integer.parseInt(linha);
          i++;
        }
        br.close();
      }catch(Exception e){
        System.out.println(e.getMessage());
      }
      
      long tempoInicio = System.currentTimeMillis();
      // ORDENAR OS INTEIROS COM selectSort ou mergeSort
      int [] newIntArr;
      //newIntArr = SelectSort.sort(intArr);
      newIntArr = MergeSort.sort(intArr);

      System.out.println("Tempo Total: " + (System.currentTimeMillis() - tempoInicio));

      // EXIBIR OS DADOS
      /*for(i = 0; i < newIntArr.length; i++)
      {
        System.out.println(newIntArr[i]);
      }*/


  }
}
