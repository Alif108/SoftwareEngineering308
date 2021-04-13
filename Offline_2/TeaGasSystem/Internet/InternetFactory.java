/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Internet;

import Controller.Controller;
import Display.Display;
import Identification.ID_card;
import Microcontroller.Microcontroller;
import Storage.Storage;
import WebServer.Framework;
import Weight.Weight;
import teagas_system.AbstractFactory;

/**
 *
 * @author Asus
 */
public class InternetFactory extends AbstractFactory {

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
        
        if(internet.equalsIgnoreCase("wifi"))
            return new WiFi();
        
        else if(internet.equalsIgnoreCase("GSM"))
            return new GSM();
        
        else if(internet.equalsIgnoreCase("ethernet"))
            return new Ethernet();
  
        else
        {
            System.out.println("The Display choice does not exist");
            return null;
        }
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
