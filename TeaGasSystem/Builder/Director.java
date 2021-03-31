/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import CustomerPackage.PackagePlan;


public class Director {
    private PackageBuilder packageBuilder;
    
    public void createPackage(String PackageName, String framework, String internet)
    {
        if(PackageName.equalsIgnoreCase("Silver"))
        {
            packageBuilder = new SilverBuilder();
        }
        else if(PackageName.equalsIgnoreCase("Gold"))
        {
            packageBuilder = new GoldBuilder();
        }
        else if(PackageName.equalsIgnoreCase("Diamond"))
        {
            packageBuilder = new DiamondBuilder();
        }
        else if(PackageName.equalsIgnoreCase("Platinum"))
        {
            packageBuilder = new PlatinumBuilder();
        }
        else
        {
            System.out.println("No Such Package");
        }
        
        packageBuilder.buildMicrocontroller();
        packageBuilder.buildDisplay();
        packageBuilder.buildFramework(framework);
        packageBuilder.buildID();
        packageBuilder.buildInternet(internet);
        packageBuilder.buildStorage();
        packageBuilder.buildWeight();
        packageBuilder.buildController();
    }
    
    public PackagePlan getPackage()
    {
        return this.packageBuilder.getPackage();
    }
}
