package adapter_pattern;

import Calculation.Calc;
import Calculation.IntegerCalc;
import CharCalculation.CharCalc;
import java.io.File;
import java.io.IOException;


public class Adapter_Pattern {

    public static void main(String[] args) throws IOException {
        
        File obj = new File("input.txt");
//        CharCalc c = new CharCalc();
//        c.calculateAsciiSum(obj);
//        Calc c = new IntegerCalc();
//        c.calculateSum(obj);
//          char c = 'b';
//          int a = Character.getNumericValue(c);
//          int a = Integer.parseInt(String.valueOf(c));  
//          System.out.println(a);
        Adapter a = new Adapter();
        System.out.println(a.calculateSum(obj));
    }
}
