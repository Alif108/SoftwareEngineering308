package unit_testing_2;

import Sort_Algorithm.InsertionSort;


public class Unit_Testing_2 {


    public static void main(String[] args) 
    {
        // TODO code application logic here
        int array[] = {71, 59};

        InsertionSort s = new InsertionSort(array);

        int result[] = s.sort(true);

        for(int i=0; i<result.length; i++)
                System.out.println(result[i]);
    }
    
}
