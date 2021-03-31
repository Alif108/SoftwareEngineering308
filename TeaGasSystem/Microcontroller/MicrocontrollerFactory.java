/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Microcontroller;

import Controller.Controller;
import Display.Display;
import Identification.ID_card;
import Internet.Internet;
import Storage.Storage;
import WebServer.Framework;
import Weight.Weight;
import teagas_system.AbstractFactory;

/**
 *
 * @author Asus
 */
public class MicrocontrollerFactory extends AbstractFactory {

    @Override
    public Microcontroller getMicrocontroller(String name) {
        
        if(name.equalsIgnoreCase("ATMega32"))
            return new ATMega32();
        
        else if(name.equalsIgnoreCase("Arduino Mega"))
            return new Arduino();
        
        else if(name.equalsIgnoreCase("Raspberry Pi"))
            return new Raspberry();
        
        else
        {
            System.out.println("This Microcontroller choice does not exist");
            return null;
        }
    }

    @Override
    public Storage getStorage(String name) {
        return null;
    }

    @Override
    public Display getDisplay(String display) {
        return null;
    }

    @Override
    public ID_card getID(String id) {
        return null;
    }

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
