package Parser;

import Aesthetics.Aesthetics;
import parser_offline_se.AbstractFactory;


public class ParserFactory extends AbstractFactory{

    @Override
    public Aesthetics getAesthetics(String name) {
        return null;
    }

    @Override
    public Parser getParser(String name) {
        if(name.equalsIgnoreCase("C"))
            return new C();
        else if(name.equalsIgnoreCase("CPP"))
            return new CPP();
        else if(name.equalsIgnoreCase("Python"))
            return new Python();
        else
        {
            System.out.println("Parser doesn't exist");
            return null;
        }
    }
}
