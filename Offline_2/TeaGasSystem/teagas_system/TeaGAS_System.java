package teagas_system;

import Builder.Director;
import java.util.Scanner;
import CustomerPackage.PackagePlan;


public class TeaGAS_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String pack;
        String internet;
        String framework;
        int choice;
        
        Scanner s = new Scanner(System.in);
        System.out.println("Select a Package: ");
        System.out.println("1. Silver");
        System.out.println("2. Gold");
        System.out.println("3. Diamond");
        System.out.println("4. Platinum");
        
        choice = s.nextInt();
        
        if(choice == 1)
            pack = "Silver";
        else if(choice == 2)
            pack = "Gold";
        else if(choice == 3)
            pack = "Diamond";
        else
            pack = "Platinum";
        
        System.out.println("Choose Internet Connection: ");
        System.out.println("1. WiFi");
        System.out.println("2. GSM");
        System.out.println("3. Ethernet");
        
        choice = s.nextInt();
        
        if(choice == 1)
            internet = "Wifi";
        else if(choice == 2)
            internet = "GSM";
        else
            internet = "Ethernet";
        
        System.out.println("Choose a Framework: ");
        System.out.println("1. Django");
        System.out.println("2. Spring");
        System.out.println("3. Laravel");
        
        choice = s.nextInt();
        
        if(choice == 1)
            framework = "Django";
        else if(choice == 2)
            framework = "Spring";
        else
            framework = "Laravel";
        
        Director d = new Director();
        d.createPackage(pack, framework, internet);
        
        PackagePlan p = d.getPackage();
        p.show();     
    }
}
