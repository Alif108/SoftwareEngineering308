/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Display.Display;
import Display.TouchScreen;
import Identification.ID_card;
import Internet.Internet;
import Microcontroller.Microcontroller;
import Storage.Storage;
import WebServer.Framework;
import Weight.Load_Sensor;
import Weight.Weight;
import Weight.Weight_Module;
import teagas_system.AbstractFactory;

/**
 *
 * @author Asus
 */
public class ControllerFactory extends AbstractFactory{

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
        if(controller.equalsIgnoreCase("Button"))
            return new ButtonController();
        else
            return new TouchScreen();
    }
    
}

