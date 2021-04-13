/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import Controller.Controller;
import Display.Display;
import Identification.ID_card;
import Internet.Internet;
import Microcontroller.Microcontroller;
import WebServer.Framework;
import Weight.Weight;
import teagas_system.AbstractFactory;

/**
 *
 * @author Asus
 */
public class StorageFactory extends AbstractFactory {

    @Override
    public Microcontroller getMicrocontroller(String name) {
        return null;
    }

    @Override
    public Storage getStorage(String name) {
       
        if(name.equalsIgnoreCase("SD"))
           return new SD_card();
        else if(name.equalsIgnoreCase("Internal Storage"))
           return new InternalStorage();
       else
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
