package mediator_offline;

import Service_Organization.JPDC;
import Service_Organization.JRTA;
import Service_Organization.JTRC;
import Service_Organization.JWSA;

import java.util.Scanner;

public class Mediator_Offline {

    public static void main(String[] args) {

        JPDC jpdc = null;
        JWSA jwsa = null;
        JRTA jrta = null;
        JTRC jtrc = null;
        JCC_mediator jcc = null;
        
        boolean initialized = false;
        
        Scanner scanner = new Scanner(System.in);
        
//        System.out.println("");
        
        while(true)
        {
            String input = scanner.nextLine();
            String[] arrOfStr = input.split(" ");
            
            if(!initialized)                                                            // if not initialized
            {
                if(arrOfStr[0].toLowerCase().equals("init"))
                {
                    jcc = new JCC_mediator();
                    jpdc = new JPDC(jcc);
                    jwsa = new JWSA(jcc);
                    jrta = new JRTA(jcc);
                    jtrc = new JTRC(jcc);
                    initialized = true;
                    
                    System.out.println("System Has Been Initialized");
                }
                else if(arrOfStr[0].toLowerCase().equals("exit"))
                {
                    break;
                }
                else
                    System.out.println("Please Initialize The System First");
            }
            else                                                                        // initialized
            {
                if(arrOfStr[0].toLowerCase().equals("init"))
                {
                    System.out.println("System Has Already Been Initialized");
                }
                else if(arrOfStr[0].toLowerCase().equals("jwsa"))                       // for JWSA
                {
                    if(jwsa != null)
                    {
                        if(arrOfStr[1].toLowerCase().equals("power"))
                        {
                            jwsa.request("power");
                        }
                        else if(arrOfStr[1].toLowerCase().equals("transport"))
                        {
                            jwsa.request("transport");
                        }
                        else if(arrOfStr[1].toLowerCase().equals("telecom"))
                        {
                            jwsa.request("telecom");
                        }
                        else if(arrOfStr[1].toLowerCase().equals("serve"))
                        {
                            jwsa.serve();
                        }
                        else
                        {
                            System.out.println("No Service Available");
                        }
                    }
                    else
                        System.out.println("NULL");
                }
                else if(arrOfStr[0].toLowerCase().equals("jpdc"))                       // for JPDC
                {
                    if(arrOfStr[1].toLowerCase().equals("water"))
                    {
                        jpdc.request("water");
                    }
                    else if(arrOfStr[1].toLowerCase().equals("transport"))
                    {
                        jpdc.request("transport");
                    }
                    else if(arrOfStr[1].toLowerCase().equals("telecom"))
                    {
                        jpdc.request("telecom");
                    }
                    else if(arrOfStr[1].toLowerCase().equals("serve"))
                    {
                        jpdc.serve();
                    }
                    else
                    {
                        System.out.println("No Service Available");
                    }
                }
                else if(arrOfStr[0].toLowerCase().equals("jrta"))                       // for JRTA
                {
                    if(arrOfStr[1].toLowerCase().equals("water"))
                    {
                        jrta.request("water");
                    }
                    else if(arrOfStr[1].toLowerCase().equals("power"))
                    {
                        jrta.request("power");
                    }
                    else if(arrOfStr[1].toLowerCase().equals("telecom"))
                    {
                        jrta.request("telecom");
                    }
                    else if(arrOfStr[1].toLowerCase().equals("serve"))
                    {
                        jrta.serve();
                    }
                    else
                    {
                        System.out.println("No Service Available");
                    }
                }
                else if(arrOfStr[0].toLowerCase().equals("jtrc"))                       // for JTRC
                {
                    if(arrOfStr[1].toLowerCase().equals("water"))
                    {
                        jtrc.request("water");
                    }
                    else if(arrOfStr[1].toLowerCase().equals("power"))
                    {
                        jtrc.request("power");
                    }
                    else if(arrOfStr[1].toLowerCase().equals("transport"))
                    {
                        jtrc.request("transport");
                    }
                    else if(arrOfStr[1].toLowerCase().equals("serve"))
                    {
                        jtrc.serve();
                    }
                    else
                    {
                        System.out.println("No Service Available");
                    }
                }
                else if(arrOfStr[0].toLowerCase().equals("exit"))
                {
                    break;
                }
                else
                {
                    System.out.println("No Service Available");
                }
            }
        }
    }
}
