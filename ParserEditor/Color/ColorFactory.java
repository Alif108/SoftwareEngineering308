/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Color;

import Aesthetics.AestheticFactory;
import Aesthetics.Aesthetics;
import Parser.Parser;

/**
 *
 * @author Asus
 */
public class ColorFactory extends AestheticFactory{

    @Override
    public Aesthetics getAesthetics(String name) {
        if(name.equalsIgnoreCase("Blue"))
            return new Blue();
        else
        {
            System.out.println("No Color of this Name Available");
            return null;
        }
    }

    @Override
    public Parser getParser(String name) {
        return null;
    }
    
}
