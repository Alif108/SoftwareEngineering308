package Service_Organization;

import mediator_offline.Mediator;

public class JRTA extends ServiceOrg{

    public JRTA(Mediator m) {
        super(m);
    }

    @Override
    public void request(String req) {
        mediator.addRequest(this, req);
    }

    @Override
    public void serve() {
        mediator.serveRequest(this);
    }   

    @Override
    public String getName() {
        return "JRTA";
    }
}
