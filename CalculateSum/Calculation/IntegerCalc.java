package Calculation;

import java.io.File;
import java.util.Scanner;

public class IntegerCalc implements Calc
{
    @Override
    public int calculateSum(File obj) 
    {
       int sum = 0;
       try 
        {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNextLine()) 
            {
                sum += myReader.nextInt();
            }
            
            myReader.close();
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

//            Scanner myReader = new Scanner(obj);
//            while (myReader.hasNextLine()) 
//            {
//                //System.out.println(myReader.next());
//                //sum += myReader.nextInt();
//                System.out.println(myReader.nextInt());
//            }
//            System.out.println(sum);
//            myReader.close();
            
