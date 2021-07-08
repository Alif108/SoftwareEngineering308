package Sort_Algorithm;

import TestHelper.ScriptGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;
import static org.junit.Assert.*;


public class InsertionSortTest {
 
    ScriptGenerator sg = new ScriptGenerator();
    
    public boolean compareElements(int x[], int y[])
    {
        List<Integer> xList = IntStream.of(x).boxed().collect(Collectors.toCollection(ArrayList::new));     
        List<Integer> yList = IntStream.of(y).boxed().collect(Collectors.toCollection(ArrayList::new));     
        
        return (xList.size() == yList.size() && xList.containsAll(yList) && yList.containsAll(xList));
    }
    
    public boolean isAscending(int x[])
    {
        for(int i=0; i<x.length-1; i++)
        {
            if(x[i+1] < x[i])
                return false;
        }
        return true;
    }
    
    public boolean isDescending(int x[])
    {
        for(int i=0; i<x.length-1; i++)
        {
            if(x[i+1] > x[i])
                return false;
        }
        return true;
    }
    
    @Test
    public void blankListTest()
    {
        int a[] = sg.generateBlankList();
        
        InsertionSort instance = new InsertionSort(a);
        
        int result[] = instance.sort(true);
        
        assertTrue(compareElements(a, result));
        assertTrue(isAscending(result));
        assertTrue(isDescending(result));
    }
    
    @Test
    public void OneNumberTest()
    {
        int a[] = sg.generateOneNumberList();
        
        InsertionSort instance = new InsertionSort(a);
        
        int result[] = instance.sort(true);
        assertTrue(compareElements(a, result));
        assertTrue(isAscending(result));
        
        result = instance.sort(false);
        assertTrue(compareElements(a, result));
        assertTrue(isDescending(result));
    }
    
    @Test
    public void TwoNumberTest()
    {
        int a[] = sg.generateTwoNumberList();
        
        InsertionSort instance = new InsertionSort(a);
        
        int result[] = instance.sort(true);
        assertTrue(compareElements(a, result));
        assertTrue(isAscending(result));
        
        result = instance.sort(false);
        assertTrue(compareElements(a, result));
        assertTrue(isDescending(result));
    }
    
    @Test
    public void randomSizedListTest()
    {
        int a[] = sg.generateRandomSizedList();
        
        InsertionSort instance = new InsertionSort(a);
        
        int result[] = instance.sort(true);
        assertTrue(compareElements(a, result));
        assertTrue(isAscending(result));
        
        result = instance.sort(false);
        assertTrue(compareElements(a, result));
        assertTrue(isDescending(result));
    }
    
    @Test
    public void randomValuedListTest()
    {
        int a[] = sg.generateRandomValuedList();
        
        InsertionSort instance = new InsertionSort(a);
        
        int result[] = instance.sort(true);
        assertTrue(compareElements(a, result));
        assertTrue(isAscending(result));
        
        result = instance.sort(false);
        assertTrue(compareElements(a, result));
        assertTrue(isDescending(result));
    }
    
    @Test
    public void ascendingListTest()
    {
        int a[] = sg.generateAscendingList();
        
        InsertionSort instance = new InsertionSort(a);
        
        int result[] = instance.sort(true);
        assertTrue(compareElements(a, result));
        assertTrue(isAscending(result));
        
        result = instance.sort(false);
        assertTrue(compareElements(a, result));
        assertTrue(isDescending(result));
    }
    
    @Test
    public void descendingListTest()
    {
        int a[] = sg.generateDescendingList();
        
        InsertionSort instance = new InsertionSort(a);
        
        int result[] = instance.sort(true);
        assertTrue(compareElements(a, result));
        assertTrue(isAscending(result));
        
        result = instance.sort(false);
        assertTrue(compareElements(a, result));
        assertTrue(isDescending(result));
    }
    
    @Test
    public void equalValuedListTest()
    {
        int a[] = sg.generateEqualValuedList();
        
        InsertionSort instance = new InsertionSort(a);
        
        int result[] = instance.sort(true);
        assertTrue(compareElements(a, result));
        assertTrue(isAscending(result));
        
        result = instance.sort(false);
        assertTrue(compareElements(a, result));
        assertTrue(isDescending(result));
    }
}
