// Service.java
public class Service{

    private Integer id;
    private String name;
    private CheckUrlStrategy checkStrategy;
    private String serviceUrl;
    private ServiceStatus ServiceStatus;
    private HealthObservable healthObservable;

    public Service(Integer id, String name, CheckUrlStrategy checkStrategy,
                   String url,HealthObservable healthObservable)
    {

        this.id=id;
        this.name=name;
        this.checkStrategy=checkStrategy;
        this.serviceUrl=url;
        this.healthObservable=healthObservable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CheckUrlStrategy getCheckStrategy() {
        return checkStrategy;
    }

    public void setCheckStrategy(CheckUrlStrategy checkStrategy) {
        this.checkStrategy = checkStrategy;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public ServiceStatus getServiceStatus() {
        return ServiceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        ServiceStatus = serviceStatus;
    }

    public ServiceStatus pingHealthCheck(){
        return checkStrategy.pingCheck(serviceUrl);
    }

    public void alertOnStatusChange()
    {

    }


}