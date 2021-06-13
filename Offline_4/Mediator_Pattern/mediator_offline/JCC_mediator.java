package mediator_offline;

import Service_Organization.JPDC;
import Service_Organization.JRTA;
import Service_Organization.JTRC;
import Service_Organization.JWSA;
import Service_Organization.ServiceOrg;

import java.util.Queue;
import java.util.LinkedList;

public class JCC_mediator implements Mediator {
    
    private JWSA jwsa;
    private JPDC jpdc;
    private JRTA jrta;
    private JTRC jtrc;
    
    protected Queue<ServiceOrg> water_q;
    protected Queue<ServiceOrg> power_q;
    protected Queue<ServiceOrg> transport_q;
    protected Queue<ServiceOrg> telecom_q;
    
    
//    public JCC_mediator(JWSA jwsa, JPDC jpdc, JRTA jrta, JTRC jtrc)
//    {
//        this.jwsa = jwsa;
//        this.jpdc = jpdc;
//        this.jrta = jrta;
//        this.jtrc = jtrc;
//    }
    
    public JCC_mediator()
    {
        water_q = new LinkedList<>();
        power_q = new LinkedList<>();
        telecom_q = new LinkedList<>();
        transport_q = new LinkedList<>();
    }
    
    public void setJPDC(JPDC jpdc)
    {
        this.jpdc = jpdc;
    }
    
    public void setJWSA(JWSA jwsa)
    {
        this.jwsa = jwsa;
    }
    
    public void setJRTA(JRTA jrta)
    {
        this.jrta = jrta;
    }
    
    public void setJTRC(JTRC jtrc)
    {
        this.jtrc = jtrc;
    }

    @Override
    public void addRequest(ServiceOrg s, String request) {
    
        if(request.toLowerCase().equals("power"))
        {
            power_q.add(s);
            System.out.println(s.getName() + " requests for POWER service");
        }
        else if(request.toLowerCase().equals("water"))
        {
            water_q.add(s);
            System.out.println(s.getName() + " requests for WATER service");
        }
        else if(request.toLowerCase().equals("transport"))
        {
            transport_q.add(s);
            System.out.println(s.getName() + " requests for TRANSPORT service");
        }
        else if(request.toLowerCase().equals("telecom"))
        {
            telecom_q.add(s);
            System.out.println(s.getName() + " requests for TELECOM service");
        }
        else
            System.out.println("No Valid Service");
    }   

    @Override
    public void serveRequest(ServiceOrg s) {
        
        ServiceOrg service;
        
        if(s.getName().equals("JPDC"))
        {
            if(power_q.size()>0)
            {
                service = power_q.remove();
                System.out.println("JPDC serves the request of " + service.getName());
            }
            else
                System.out.println("No Service to Serve");
        }
        else if(s.getName().equals("JWSA"))
        {
            if(water_q.size()>0)
            {
                service = water_q.remove();
                System.out.println("JWSA serves the request of " + service.getName());
            }
            else
                System.out.println("No Service to Serve");
        }
        else if(s.getName().equals("JRTA"))
        {
            if(transport_q.size()>0)
            {
                service = transport_q.remove();
                System.out.println("JRTA serves the request of " + service.getName());
            }
            else
                System.out.println("No Service to Serve");
        }
        else
        {
            if(telecom_q.size()>0)
            {
                service = telecom_q.remove();
                System.out.println("JTRC serves the request of " + service.getName());
            }
            else
                System.out.println("No Service to Serve");
        }
    }
}