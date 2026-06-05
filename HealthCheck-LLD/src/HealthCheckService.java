import java.util.ArrayList;
import java.util.List;

// HealthCheckService.java
public class HealthCheckService implements HealthObservable{

    private List<Service> list;

    public HealthCheckService()
    {
        list=new ArrayList<>();
    }

    public void registerService(Service service){

        list.add(service);

    }




    @Override
    public void pingServices(int interval) {

    }

    @Override
    public void renderDashBoard() {

    }

    @Override
    public void handleStatusChange(String service, ServiceStatus oldStatus) {

    }
}
