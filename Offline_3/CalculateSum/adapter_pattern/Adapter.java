package adapter_pattern;

import Calculation.Calc;
import Calculation.IntegerCalc;
import CharCalculation.CharCalc;
import java.io.File;
import java.io.FileReader;

public class Adapter extends CharCalc implements Calc 
{
//    CharCalc ch;

    @Override
    public int calculateSum(File obj)
    {
        int sum = 0;
        try 
        {
            FileReader F = new FileReader(obj);
            int b; 
            
            b = F.read();
            if(b!=-1)                                           // if first character is not null i.e. file not empty
            {
                if(b<48 || b>57)                                // if not integer
                {
//                    CharCalc ch = new CharCalc();
//                    return ch.calculateAsciiSum(obj);
                      return calculateAsciiSum(obj);
                }
                else
                {
                    Calc ic = new IntegerCalc();
                    return ic.calculateSum(obj);
                }    
            }
        } 
        catch (Exception ex) 
        {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
        return -1;
    }
}
