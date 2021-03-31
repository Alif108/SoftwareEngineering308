/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Style;

import Aesthetics.AestheticFactory;
import Aesthetics.Aesthetics;
import Parser.Parser;

/**
 *
 * @author Asus
 */
public class StyleFactory extends AestheticFactory{

    @Override
    public Aesthetics getAesthetics(String name) {
        if(name.equalsIgnoreCase("Normal"))
            return new Normal();
        else
        {
            System.out.println("Style of this name is not Available");
            return null;
        }
    }

    @Override
    public Parser getParser(String name) {
        return null;
    }
    
}
