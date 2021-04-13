/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import Controller.Controller;

/**
 *
 * @author Asus
 */
public class TouchScreen implements Display, Controller{

    @Override
    public String getDisplay() {
        return "Touch Screen Display";
    }  

    @Override
    public String getController() {
        return "Touch Screen Controller";
    }
}
