/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import CustomerPackage.Diamond;
import teagas_system.AbstractFactory;
import teagas_system.FactoryProducer;
import CustomerPackage.PackagePlan;

/**
 *
 * @author Asus
 */
public class DiamondBuilder implements PackageBuilder {

    private AbstractFactory factory;
    private Diamond diamond;
    
    DiamondBuilder()
    {
        diamond = new Diamond();
    }
    
    @Override
    public void buildMicrocontroller() {
        factory = FactoryProducer.getFactory("Microcontroller");
        diamond.setMicrocontroller(factory.getMicrocontroller("Raspberry Pi"));
    }

    @Override
    public void buildDisplay() {
        factory = FactoryProducer.getFactory("Display");
        diamond.setDisplay(factory.getDisplay("Touch Screen"));
    }

    @Override
    public void buildID() {
        factory = FactoryProducer.getFactory("ID");
        diamond.setID(factory.getID("NFC"));
    }

    @Override
    public void buildInternet(String internet) {
        factory = FactoryProducer.getFactory("Internet");
        diamond.setInternet(factory.getInternet(internet));
    }

    @Override
    public void buildStorage() {
        factory = FactoryProducer.getFactory("Storage");
        diamond.setStorage(factory.getStorage("Internal Storage"));
    }

    @Override
    public void buildFramework(String Framework) {
        factory = FactoryProducer.getFactory("Framework");
        diamond.setFramework(factory.getFramework(Framework));
    }

    @Override
    public void buildWeight() {
        factory = FactoryProducer.getFactory("Weight");
        diamond.setWeight(factory.getWeight("Load Sensor"));
    }

    public Diamond getPackage() {
         return this.diamond;
    }

    @Override
    public void buildController() {
        factory = FactoryProducer.getFactory("Controller");
        diamond.setController(factory.getController("Touch Screen"));
    }
}