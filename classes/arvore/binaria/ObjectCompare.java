package classes.arvore.binaria;

public class ObjectCompare {
    
    public static char type = 'I';

    public static void setType(char c)
    {
        ObjectCompare.type = c;
    }

    public static int compare(Object first, Object second)
    {
        Integer firstInt    = (Integer) first;
        Integer secondInt   = (Integer) second;

        if(ObjectCompare.type == 'I') 
        {
            if(firstInt < secondInt)    return -1;
            if(firstInt == secondInt)   return  0;
            if(firstInt > secondInt)    return  1;
        }
        return -2;
    }
}