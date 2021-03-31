/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Identification;

import Controller.Controller;
import Display.Display;
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
public class ID_Factory extends AbstractFactory {

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
        return null;
    }

    @Override
    public ID_card getID(String id) {
        
        if(id.equalsIgnoreCase("RFID"))
            return new RFID();
        
        else if(id.equalsIgnoreCase("NFC"))
            return new NFC();
        
        else
        {
            System.out.println("This ID choice does not exist");
            return null;
        }
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
