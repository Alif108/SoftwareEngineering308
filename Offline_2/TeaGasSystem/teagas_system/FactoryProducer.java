/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teagas_system;

import Controller.ControllerFactory;
import Display.DisplayFactory;
import Identification.ID_Factory;
import Internet.InternetFactory;
import Microcontroller.MicrocontrollerFactory;
import Storage.StorageFactory;
import WebServer.FrameworkFactory;
import Weight.WeightFactory;

/**
 *
 * @author Asus
 */
public class FactoryProducer {
     public static AbstractFactory getFactory(String choice)
     {
         if(choice.equalsIgnoreCase("Display"))
             return new DisplayFactory();
         
         else if(choice.equalsIgnoreCase("ID"))
             return new ID_Factory();
         
         else if(choice.equalsIgnoreCase("Internet"))
             return new InternetFactory();
         
         else if(choice.equalsIgnoreCase("Microcontroller"))
             return new MicrocontrollerFactory();
         
         else if(choice.equalsIgnoreCase("Storage"))
             return new StorageFactory();
         
         else if(choice.equalsIgnoreCase("Weight"))
             return new WeightFactory();
         
         else if(choice.equalsIgnoreCase("Framework"))
             return new FrameworkFactory();
         
         else if(choice.equalsIgnoreCase("Controller"))
             return new ControllerFactory();
         
         else
         {
             System.out.println("This choice of Factory does not exist");
             return null;
         }
     }
}
