/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aesthetics;

import Parser.Parser;
import parser_offline_se.AbstractFactory;

/**
 *
 * @author Asus
 */
public abstract class AestheticFactory extends AbstractFactory{

    @Override
    public abstract Aesthetics getAesthetics(String name);

    @Override
    public abstract Parser getParser(String name);
        
}
