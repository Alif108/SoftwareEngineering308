package CharCalculation;

import java.io.File;
import java.io.FileReader;

public class CharCalc {
    public int calculateAsciiSum(File obj)
    {
       int sum = 0;
       try 
        {
            FileReader F = new FileReader(obj);
            int b;
            
            while((b=F.read())!=-1)
            {
                if(b!=32)
                    sum += b;
            }
            
            //System.out.println(sum);
            F.close();
            return sum;
        } 
       catch (Exception e) 
       {
            System.out.println("An error occurred.");
            e.printStackTrace();
       }
        return -1;
    }
}
