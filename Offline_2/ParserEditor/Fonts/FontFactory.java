/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonts;

import Aesthetics.AestheticFactory;
import Aesthetics.Aesthetics;
import Parser.Parser;

/**
 *
 * @author Asus
 */
public class FontFactory extends AestheticFactory{

    @Override
    public Aesthetics getAesthetics(String name) {
        
        if(name.equalsIgnoreCase("Courier New"))
            return new Courier_New();
        
        else if(name.equalsIgnoreCase("Monaco"))
            return new Monaco();
        
        else if(name.equalsIgnoreCase("Consolas"))
            return new Consolas();
        
        else
        {
            System.out.println("No Font of this name exists");
            return null;
        }
    }

    @Override
    public Parser getParser(String name) {
        return null;
    }
    
}
