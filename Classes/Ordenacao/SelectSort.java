package Classes.Ordenacao;

public class SelectSort {

  public SelectSort(){}

  public static int[] sort(int[] inteiros)
  {
    int i, j, aux, sizeList = inteiros.length;
    
    for(i = 0; i < (sizeList-1); i++)
    {
      for(j = (i+1); j < sizeList; j++)
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