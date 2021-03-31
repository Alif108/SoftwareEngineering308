/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser_offline_se;

import Color.ColorFactory;
import Fonts.FontFactory;
import Parser.ParserFactory;
import Style.StyleFactory;

/**
 *
 * @author Asus
 */
public class FactoryProducer {
    
    public static AbstractFactory getFactory(String name)
    {
        if(name.equalsIgnoreCase("Parser"))
            return new ParserFactory();
        
        else if(name.equalsIgnoreCase("Font"))
            return new FontFactory();
        
        else if(name.equalsIgnoreCase("Style"))
            return new StyleFactory();
        
        else if(name.equalsIgnoreCase("Color"))
            return new ColorFactory();
        
        else
        {
            System.out.println("No Factory Under this name");
            return null;
        }
    }
}
