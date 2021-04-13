/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser_offline_se;

import Aesthetics.Aesthetics;
import Parser.Parser;

/**
 *
 * @author Asus
 */
public abstract class AbstractFactory {
    
    public abstract Aesthetics getAesthetics(String name);
    public abstract Parser getParser(String name);
}
