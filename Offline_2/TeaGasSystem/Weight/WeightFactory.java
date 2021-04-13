/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Weight;

import Controller.Controller;
import Display.Display;
import Identification.ID_card;
import Internet.Internet;
import Microcontroller.Microcontroller;
import Storage.Storage;
import WebServer.Framework;
import teagas_system.AbstractFactory;

/**
 *
 * @author Asus
 */
public class WeightFactory extends AbstractFactory{

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
        
        if(weight.equalsIgnoreCase("Load Sensor"))
            return new Load_Sensor();
        else if(weight.equalsIgnoreCase("Weight Module"))
            return new Weight_Module();
        else
        {
            System.out.println("This Weight choice does not exist");
            return null;
        }
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
