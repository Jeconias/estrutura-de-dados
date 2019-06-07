package Classes.Ordenacao;

public class SelectSort {

  public SelectSort(){}

  public static int[] ordenar(int[] inteiros)
  {
    int i, j, aux, sizeList = inteiros.length;
    
    for(i = 0; i < (sizeList-2); i++)
    {
      for(j = (i+1); j < (sizeList-1); j++)
      {
        if(inteiros[j] < inteiros[i])
        {
          aux = inteiros[j];
          inteiros[j] = inteiros[i];
          inteiros[i] = aux;
        }
      }
    }
    return inteiros;
  }
}