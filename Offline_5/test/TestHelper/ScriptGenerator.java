package TestHelper;

public class ScriptGenerator 
{
    public int[] generateBlankList()
    {
          int a[] = {};
          return a;
    }
    
    public int[] generateOneNumberList()
    {
        int x = (int) (Math.random()*100);
        int a[] = {x};
 
        return a;
    }
    
    public int[] generateTwoNumberList()
    {
        int x = (int) (Math.random()*100);
        int y = (int) (Math.random()*100);
        
        int a[] = {x, y};
        
        return a;
    }
    
    public int[] generateRandomSizedList()
    {
        int size = (int) (Math.random()*100);
        
        int a[] = new int[size];
        
        for(int i=0; i<size; i++)
            a[i] = (int) (Math.random()*100);
        
        return a;
    }
    
    public int[] generateRandomValuedList()
    {
        int a[] = new int[100];
        
        for(int i=0; i<100; i++)
            a[i] = (int) (Math.random()*1000);
        
        return a;
    }
    
    public int[] generateAscendingList()
    {
        int size = (int) (Math.random()*100);
        
        int a[] = new int[size];
        
        a[0] = (int) (Math.random()*100);
        
        for(int i=1; i<size; i++)
            a[i] = a[i-1] + (int) (Math.random()*100);      // consecutive numbers are always greater
        
        return a;
    }
    
    public int[] generateDescendingList()
    {
        int size = (int) (Math.random()*100);
        
        int a[] = new int[size];
        
        a[0] = (int) (Math.random()*100);
        
        for(int i=1; i<size; i++)
            a[i] = a[i-1] - (int) (Math.random()*100);      // consecutive numbers are always smaller
        
        return a;
    }
    
    public int[] generateEqualValuedList()
    {
        int size = (int) (Math.random()*100);
        
        int a[] = new int[size];
        
        int x = (int) (Math.random()*100);
        
        for(int i=0; i<size; i++)
            a[i] = x;                                       // populating with the same number
        
        return a;
    }
}
