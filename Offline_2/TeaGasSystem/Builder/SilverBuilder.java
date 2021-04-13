/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import CustomerPackage.Silver;
import teagas_system.AbstractFactory;
import teagas_system.FactoryProducer;
import CustomerPackage.PackagePlan;

/**
 *
 * @author Asus
 */
public class SilverBuilder implements PackageBuilder {

    private AbstractFactory factory;
    private Silver silver;
    
    SilverBuilder()
    {
        silver = new Silver();
    }
    
    @Override
    public void buildMicrocontroller() {
        factory = FactoryProducer.getFactory("Microcontroller");
        silver.setMicrocontroller(factory.getMicrocontroller("ATMega32"));
    }

    @Override
    public void buildDisplay() {
        factory = FactoryProducer.getFactory("Display");
        silver.setDisplay(factory.getDisplay("LCD"));
    }

    @Override
    public void buildID() {
        factory = FactoryProducer.getFactory("ID");
        silver.setID(factory.getID("RFID"));
    }

    @Override
    public void buildInternet(String internet) {
        factory = FactoryProducer.getFactory("Internet");
        
        if(!internet.equalsIgnoreCase("Ethernet"))
        {
            silver.setInternet(factory.getInternet(internet));
        }
        else
            System.out.println("Ethernet internet module is not compatible with ATMega32");
    }

    @Override
    public void buildStorage() {
        factory = FactoryProducer.getFactory("Storage");
        silver.setStorage(factory.getStorage("SD"));
    }

    @Override
    public void buildFramework(String Framework) {
        factory = FactoryProducer.getFactory("Framework");
        silver.setFramework(factory.getFramework(Framework));
    }

    @Override
    public void buildWeight() {
        factory = FactoryProducer.getFactory("Weight");
        silver.setWeight(factory.getWeight("Load Sensor"));
    }

    @Override
    public PackagePlan getPackage() {
        return this.silver;
    }
    
    @Override
    public void buildController() {
        factory = FactoryProducer.getFactory("Controller");
        silver.setController(factory.getController("Button"));
    }
}
