/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teagas_system;

import Controller.Controller;
import Display.Display;
import Identification.ID_card;
import Internet.Internet;
import Microcontroller.Microcontroller;
import Storage.Storage;
import WebServer.Framework;
import Weight.Weight;

/**
 *
 * @author Asus
 */
public abstract class AbstractFactory {
    
    public abstract Microcontroller getMicrocontroller(String name);
    public abstract Storage getStorage(String name);
    public abstract Display getDisplay(String display);
    public abstract ID_card getID(String id);
    public abstract Internet getInternet(String internet);
    public abstract Weight getWeight(String weight);
    public abstract Framework getFramework(String framework);
    public abstract Controller getController(String controller);
}
