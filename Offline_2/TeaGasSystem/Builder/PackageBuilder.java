/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import CustomerPackage.PackagePlan;

/**
 *
 * @author Asus
 */
public interface PackageBuilder {
    
    public void buildMicrocontroller();
    public void buildDisplay();
    public void buildID();
    public void buildInternet(String internet);
    public void buildStorage();
    public void buildFramework(String framework);
    public void buildWeight();
    public void buildController();
    public PackagePlan getPackage();
}
