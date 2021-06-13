package Service_Organization;

import mediator_offline.Mediator;

public abstract class ServiceOrg {
    
    protected Mediator mediator;
    
    public ServiceOrg(Mediator m)
    {
        this.mediator = m;
    }
    
    abstract public void request(String req);
    abstract public void serve();
    abstract public String getName();
}
