/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import CustomerPackage.Gold;
import teagas_system.AbstractFactory;
import teagas_system.FactoryProducer;
import CustomerPackage.PackagePlan;

/**
 *
 * @author Asus
 */
public class GoldBuilder implements PackageBuilder {

    private AbstractFactory factory;
    private Gold gold;
    
    GoldBuilder()
    {
        gold = new Gold();
    }
    
    @Override
    public void buildMicrocontroller() {
        factory = FactoryProducer.getFactory("Microcontroller");
        gold.setMicrocontroller(factory.getMicrocontroller("Arduino Mega"));
    }

    @Override
    public void buildDisplay() {
        factory = FactoryProducer.getFactory("Display");
        gold.setDisplay(factory.getDisplay("LED"));
    }

    @Override
    public void buildID() {
        factory = FactoryProducer.getFactory("ID");
        gold.setID(factory.getID("RFID"));
    }

    @Override
    public void buildInternet(String internet) {
        factory = FactoryProducer.getFactory("Internet");
        
        if(!internet.equalsIgnoreCase("Ethernet"))
        {
            gold.setInternet(factory.getInternet(internet));
        }
        else
            System.out.println("Ethernet internet module is not compatible with Arduino");
    }

    @Override
    public void buildStorage() {
        factory = FactoryProducer.getFactory("Storage");
        gold.setStorage(factory.getStorage("SD"));
    }

    @Override
    public void buildFramework(String Framework) {
        factory = FactoryProducer.getFactory("Framework");
        gold.setFramework(factory.getFramework(Framework));
    }

    @Override
    public void buildWeight() {
        factory = FactoryProducer.getFactory("Weight");
        gold.setWeight(factory.getWeight("Weight Module"));
    }
    
   @Override
    public PackagePlan getPackage() {
        return this.gold;
    }
    
    @Override
    public void buildController() {
        factory = FactoryProducer.getFactory("Controller");
        gold.setController(factory.getController("Button"));
    }
}
