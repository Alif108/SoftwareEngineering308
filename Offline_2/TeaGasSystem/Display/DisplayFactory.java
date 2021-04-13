/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import Controller.Controller;
import Identification.ID_card;
import Internet.Internet;
import Microcontroller.Microcontroller;
import Storage.Storage;
import WebServer.Framework;
import Weight.Weight;
import teagas_system.AbstractFactory;

/**
 *
 * @author Asus
 */
public class DisplayFactory extends AbstractFactory {

    @Override
    public Microcontroller getMicrocontroller(String name) {
        return null;
    }

    @Override
    public Storage getStorage(String name) {
        return null;
    }

    @Override
    public Display getDisplay(String display) {
        
        if(display.equalsIgnoreCase("LCD"))
            return new LCD();
        
        else if(display.equalsIgnoreCase("LED"))
            return new LED();
        
        else if(display.equalsIgnoreCase("Touch Screen"))
            return new TouchScreen();
        
        else
        {
            System.out.println("The Display choice does not exist");
            return null;
        }
    }

    @Override
    public ID_card getID(String id) {
        return null;    }

    @Override
    public Internet getInternet(String internet) {
        return null;
    }

    @Override
    public Weight getWeight(String weight) {
        return null;
    }

    @Override
    public Framework getFramework(String framework) {
        return null;
    }

    @Override
    public Controller getController(String controller) {
        return null;
    }
    
}
