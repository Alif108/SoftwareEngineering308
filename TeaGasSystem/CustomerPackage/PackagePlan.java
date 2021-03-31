/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerPackage;

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
public interface PackagePlan {
    
    public void setMicrocontroller(Microcontroller m);
    public void setWeight(Weight w);
    public void setInternet(Internet i);
    public void setFramework(Framework f);
    public void setStorage(Storage s);
    public void setID(ID_card id);
    public void setDisplay(Display d);
    public void setController(Controller c);
    public void show();
}
