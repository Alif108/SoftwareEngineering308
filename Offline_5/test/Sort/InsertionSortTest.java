package Sort;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InsertionSortTest {
  
    @Test
    public void blankListTest()
    {
        int array[] = {};
        
        InsertionSort instance = new InsertionSort(array);
        int[] expected = {};
        int[] actual = instance.sort(true);
        
        assertNotSame(array, actual);                           // testing if original list has been altered
        assertArrayEquals(expected, actual);                    // testing for ascending order

        actual = instance.sort(false);
        assertNotSame(array, actual);                           // testing if original list has been altered
        assertArrayEquals(expected, actual);                    // testing for descending order
    }
    
    @Test
    public void oneNumberTest()
    {
        int array[] = {4};
        List<Integer> inputList = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));     // converting to list
                
        int[] expected = {4};
        
        InsertionSort instance = new InsertionSort(array);
        
        int[] actual = instance.sort(true);         // sorting in asc
        assertNotSame(array, actual);               // checking if the original array has been altered
        
        List<Integer> resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));   // converting to list
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));    // checking if the values of the liss has been changed
        assertArrayEquals(expected, actual);        // checking for ascending
        
        actual = instance.sort(false);              // sorting in desc
        assertNotSame(array, actual);               // checking if the original array has been altered
        
        resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));   // converting to list
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));    // checking if the values of the liss has been changed
        assertArrayEquals(expected, actual);        // checking for descending
    }
    
    @Test
    public void twoNumbersTest()
    {
        int array[] = {93, 3};
        List<Integer> inputList = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));     // converting to list
       
        InsertionSort instance = new InsertionSort(array);
         
        int expected[] = {3, 93};
        int[] actual = instance.sort(true);         // sorting in asc
        List<Integer> resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));   //converting to list
        
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));    // checking if values of list has been changed
        assertNotSame(array, actual);               // checking if original array has been altered
        assertArrayEquals(expected, actual);        // testing for ascending
        
        int expected2[] = {93, 3};
        actual = instance.sort(false);               // sorting in desc
        resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));     //converting to list
        
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));   // checking if values of list has been changed 
        assertNotSame(array, actual);               // checking if original array has been altered
        assertArrayEquals(expected2, actual);       // testing for ascending
    }
    
    @Test
    public void randomListTest()
    {
        int size = (int) (Math.random() * 100);
        
        int array[] = new int[size];
        List<Integer> inputList = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        int[] actual = new InsertionSort(array).sort(true);
        List<Integer> resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        Arrays.sort(array, 0, size);
        int[] expected = array;
        
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));    // checking if values of original list has been changed
        assertNotSame(array, actual);               // checking if original list has bee altered
        assertArrayEquals(expected, actual);        // checking the outcome
    }
    
    @Test
    public void ascendingTest()
    {   
        int array[] = {3, 4, 5, 6};
        List<Integer> inputList = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        int[] expected = {3, 4, 5, 6};
        int[] actual = new InsertionSort(array).sort(true);     // sorting in asc
        List<Integer> resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));   
        
        assertNotSame(array, actual);               // checking if original list has been altered
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));    // checking if values of original list has been changed
        assertArrayEquals(expected, actual);

        int[] expected2 = {6, 5, 4, 3};
        actual = new InsertionSort(array).sort(false);     // sorting in desc
        resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));   
        
        assertNotSame(array, actual);               // checking if original list has been altered
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));    // checking if values of original list has been changed
        assertArrayEquals(expected2, actual);
    }
    
    @Test
    public void descendingTest()
    {   
        int array[] = {6, 5, 4, 3};
        List<Integer> inputList = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        int[] expected = {3, 4, 5, 6};
        int[] actual = new InsertionSort(array).sort(true);     // sorting in asc
        List<Integer> resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));   
        
        assertNotSame(array, actual);               // checking if original list has been altered
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));    // checking if values of original list has been changed
        assertArrayEquals(expected, actual);

        int[] expected2 = {6, 5, 4, 3};
        actual = new InsertionSort(array).sort(false);     // sorting in desc
        resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));   
        
        assertNotSame(array, actual);               // checking if original list has been altered
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));    // checking if values of original list has been changed
        assertArrayEquals(expected2, actual);
    }
    
    @Test
    public void equalNumbersTest()
    {   
        int array[] = {8, 8, 8, 8, 8};
        List<Integer> inputList = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        int[] expected = {8, 8, 8, 8, 8};
        
        InsertionSort instance = new InsertionSort(array);
        
        int[] actual = instance.sort(true);             // sorting in asc
        List<Integer> resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        assertNotSame(array, actual);
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));
        assertArrayEquals(expected, actual);
       
        actual = instance.sort(false); 
        resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        assertNotSame(array, actual);
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));
        assertArrayEquals(expected, actual);   
    }
    
    @Test
    public void negativeNumbersTest()
    {   
        int array[] = {-3, -6, -22, -10};
        List<Integer> inputList = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        InsertionSort instance = new InsertionSort(array);
        
        int[] expected = {-22, -10, -6, -3};
        int[] actual = instance.sort(true);
        List<Integer> resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        assertNotSame(array, actual);
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));
        assertArrayEquals(expected, actual);            // testing for ascending order
        
        int[] expected2 = {-3, -6, -10, -22};
        actual = instance.sort(false); 
        resultList = IntStream.of(actual).boxed().collect(Collectors.toCollection(ArrayList::new));
        
        assertNotSame(array, actual);
        assertTrue(inputList.size() == resultList.size() && inputList.containsAll(resultList) && resultList.containsAll(inputList));
        assertArrayEquals(expected2, actual);            // testing for ascending order
    }
}
