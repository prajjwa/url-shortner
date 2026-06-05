public interface HealthObservable{
    void registerService(Service service);
    void pingServices(int interval);
    void renderDashBoard();
    void handleStatusChange(String service,ServiceStatus oldStatus);

}
