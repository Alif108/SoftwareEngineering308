/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;

import Color.Colour;
import Fonts.Font;
import Parser.Parser;
import Style.Style;
import parser_offline_se.AbstractFactory;
import parser_offline_se.FactoryProducer;

/**
 *
 * @author Asus
 */
public class Editor {

    protected static Editor obj = null;
    
    private AbstractFactory factory;
    private Font font;
    private Parser parser;
    private Colour color;
    private Style style;

    protected Editor()
    {
        factory = null;
        font = null;
        parser = null;
        color = null;
        style = null;
    }

    public static Editor getInstance()                      /// Only one instance can be created
    {
        if(obj == null)
            obj = new Editor();

        return obj;
    }
    
    public void setEditor(String fileName)
    {
        if(fileName.substring(fileName.length()-1).equalsIgnoreCase("c"))
        {
            factory = FactoryProducer.getFactory("Parser");
            parser = factory.getParser("C");
            
            factory = FactoryProducer.getFactory("Font");
            font = (Font) factory.getAesthetics("Courier New");
            
            factory = FactoryProducer.getFactory("Style");
            style = (Style) factory.getAesthetics("Normal");
            
            factory = FactoryProducer.getFactory("Color");
            color = (Colour) factory.getAesthetics("Blue");
        }
        
        else if(fileName.substring(fileName.length()-2).equalsIgnoreCase("py"))
        {
            factory = FactoryProducer.getFactory("Parser");
            parser = factory.getParser("Python");
            
            factory = FactoryProducer.getFactory("Font");
            font = (Font) factory.getAesthetics("Consolas");
            
            factory = FactoryProducer.getFactory("Style");
            style = (Style) factory.getAesthetics("Normal");
            
            factory = FactoryProducer.getFactory("Color");
            color = (Colour) factory.getAesthetics("Blue");
        }
        else if(fileName.substring(fileName.length()-3).equalsIgnoreCase("cpp"))
        {
            factory = FactoryProducer.getFactory("Parser");
            parser = factory.getParser("CPP");
            
            factory = FactoryProducer.getFactory("Font");
            font = (Font) factory.getAesthetics("Monaco");
            
            factory = FactoryProducer.getFactory("Style");
            style = (Style) factory.getAesthetics("Normal");
            
            factory = FactoryProducer.getFactory("Color");
            color = (Colour) factory.getAesthetics("Blue");
        }
        else
        {
            System.out.println("File extension not recognized");
        }
    }
    
    public void show()
    {
        if(font!= null && parser!= null && color!= null && style!= null)
        {
            System.out.println("Parser: " + this.parser.getParser());
            System.out.println("Font: " + this.font.getName());
            System.out.println("Color: " + this.color.getName());
            System.out.println("Style: " + this.style.getName());
        }
        else
        {
            System.out.println("Couldn't Build Parser");
        }
    }
}
