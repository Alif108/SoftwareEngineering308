package unit_testing;

import Sort.InsertionSort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Unit_Testing {

    public static void main(String[] args) {
        
    int[] array = {1, 2, 3, 4, 5};
    List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        
    InsertionSort s = new InsertionSort(array);
    
    for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
        
//        Arrays.sort(x, 0, x.length);
//
//        for(int i=0; i<x.length; i++)
//            System.out.println(x[i]);
//        
//        System.out.println("");
//        
//        for(int i=0; i<a.length; i++)
//            System.out.println(a[i]);
//        List<Integer> list = Arrays.asList(a);
    }    
}
