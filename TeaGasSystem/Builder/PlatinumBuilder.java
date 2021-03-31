/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import CustomerPackage.Platinum;
import teagas_system.AbstractFactory;
import teagas_system.FactoryProducer;
import CustomerPackage.PackagePlan;

/**
 *
 * @author Asus
 */
public class PlatinumBuilder implements PackageBuilder {

    private AbstractFactory factory;
    private Platinum platinum;
    
    PlatinumBuilder()
    {
        platinum = new Platinum();
    }
    
    @Override
    public void buildMicrocontroller() {
        factory = FactoryProducer.getFactory("Microcontroller");
        platinum.setMicrocontroller(factory.getMicrocontroller("Raspberry Pi"));
    }

    @Override
    public void buildDisplay() {
        factory = FactoryProducer.getFactory("Display");
        platinum.setDisplay(factory.getDisplay("Touch Screen"));
    }

    @Override
    public void buildID() {
        factory = FactoryProducer.getFactory("ID");
        platinum.setID(factory.getID("NFC"));
    }

    @Override
    public void buildInternet(String internet) {
        factory = FactoryProducer.getFactory("Internet");
        platinum.setInternet(factory.getInternet(internet));
    }

    @Override
    public void buildStorage() {
        factory = FactoryProducer.getFactory("Storage");
        platinum.setStorage(factory.getStorage("Internal Storage"));
    }

    @Override
    public void buildFramework(String Framework) {
        factory = FactoryProducer.getFactory("Framework");
        platinum.setFramework(factory.getFramework(Framework));
    }

    @Override
    public void buildWeight() {
        factory = FactoryProducer.getFactory("Weight");
        platinum.setWeight(factory.getWeight("Weight Module"));
    }
    
   @Override
    public PackagePlan getPackage() {
        return this.platinum;
    }
    
    @Override
    public void buildController() {
        factory = FactoryProducer.getFactory("Controller");
        platinum.setController(factory.getController("Touch Screen"));
    }
}
