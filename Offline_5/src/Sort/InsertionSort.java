package Sort;

import java.util.*;

public class InsertionSort 
{
    int array[];
    
    public InsertionSort(int x[])
    {
        int size = x.length;
        array = new int[size];
        
        for(int i=0; i<size; i++)
        {
            array[i] = x[i];
        }
    }
    
    public int[] sort(Boolean asc) 
    {
        int size = array.length;

        for (int step = 1; step < size; step++) 
        {
          int key = array[step];
          int j = step - 1;

          // Compare key with each element on the left of it until an element smaller than
          // it is found.
          // For descending order, change key<array[j] to key>array[j].
          while (j >= 0 && key < array[j]) 
          {
            array[j + 1] = array[j];
            --j;
          }

          // Place key at after the element just smaller than it.
          array[j + 1] = key;
        }
        if(!asc)                                       //DESCENDING
        {
            int temp;
            
            for(int i=0; i<array.length/2; i++)
            {
                temp = array[i];
                array[i] = array[size-i-1];
                array[size-i-1] = temp;
            }
            return array;
        }
        else                                        //ASCENDING
            return array;
    }
}
