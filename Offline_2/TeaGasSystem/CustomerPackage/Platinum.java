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
public class Platinum implements PackagePlan {
    
    private Microcontroller microcontroller;
    private Weight weight;
    private Internet internet;
    private Framework framework;
    private Storage storage;
    private Display display;
    private ID_card id_card;
    private Controller controller;

    @Override
    public void setMicrocontroller(Microcontroller m) {
        this.microcontroller = m;
    }

    @Override
    public void setWeight(Weight w) {
        this.weight = w;
    }

    @Override
    public void setInternet(Internet i) {
        this.internet = i;
    }

    @Override
    public void setFramework(Framework f) {
        this.framework = f;
    }

    @Override
    public void setStorage(Storage s) {
        this.storage = s;
    }

    @Override
    public void setID(ID_card id) {
        this.id_card = id;
    }

    @Override
    public void setDisplay(Display d) {
        this.display = d;
    }

    @Override
    public void show() {
        if(this.microcontroller!=null && this.controller!=null && this.display!= null && this.framework!=null && this.id_card!= null && this.internet!=null && this.storage!=null && this.weight!=null)
        {
            System.out.println("Package: Platinum");
            System.out.println("Microcontroller/Microprocessor: " + this.microcontroller.getName());
            System.out.println("Weight Measurement: " + this.weight.getType());
            System.out.println("Identification: " + this.id_card.getCard());
            System.out.println("Storage: " + this.storage.getStorage());
            System.out.println("Display: " + this.display.getDisplay());
            System.out.println("Internet Connection: " + this.internet.getInternet());
            System.out.println("Controller: " + this.controller.getController());
            System.out.println("Framework: " + this.framework.getFramework());
        }
        else
            System.out.println("Couldn't build device");
    }

    @Override
    public void setController(Controller c) {
        this.controller = c;
    }
}