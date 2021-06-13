package mediator_offline;

import Service_Organization.ServiceOrg;

public interface Mediator {
    
    public void addRequest(ServiceOrg s, String request);
    public void serveRequest(ServiceOrg s);
}
