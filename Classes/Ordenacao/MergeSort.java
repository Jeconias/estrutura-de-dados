package Classes.Ordenacao;

import java.util.Arrays;

public class MergeSort {

    public MergeSort(){}

    public static int[] sort(int[] listData)
    {
        int sizeArr = listData.length, sizeS1 = (sizeArr / 2), sizeS2 = sizeS1;

        if(sizeArr > 1)
        {
            int[] s1 = Arrays.copyOfRange(listData, 0, sizeS1);
            int[] s2 = Arrays.copyOfRange(listData, sizeS2, sizeArr);
            s1 = MergeSort.sort(s1);
            s2 = MergeSort.sort(s2);
            return MergeSort.merge(s1, s2);
        }

        return listData;
    }

    public static int[] merge(int[] s1, int[] s2)
    {   
        int sizeS1 = s1.length, sizeS2 = s2.length, i = 0, j = 0, a = 0;
        int[] s = new int[sizeS1 + sizeS2];

        while(i < sizeS1 && j < sizeS2)
        {
            if(s1[i] <= s2[j])
            {
                s[a++] = s1[i++];
            }else{
                s[a++] = s2[j++];
            }
        }

        while(i < sizeS1)
        {
            s[a++] = s1[i++];
        }

        while(j < sizeS2)
        {
            s[a++] = s2[j++];
        }

        return s;
    }


}