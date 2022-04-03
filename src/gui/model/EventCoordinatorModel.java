package gui.model;
import be.EventCoordinator;
import bll.interfaces.IEventCoordinatorManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class EventCoordinatorModel{

    private IEventCoordinatorManager eventCoordinatorManager;
    private ObservableList<EventCoordinator> eventCoordinatorList = FXCollections.observableArrayList();
    private EventCoordinator whoIsLogin = null;

    public EventCoordinatorModel(IEventCoordinatorManager eventCoordinatorManager) {
        this.eventCoordinatorManager = eventCoordinatorManager;
        this.eventCoordinatorList.addAll(eventCoordinatorManager.getAllEventCoordinators());
    }

    public EventCoordinator checkCredential(String userName, String password){
        return eventCoordinatorManager.checkCredential(userName, password);
    }

    public void createEventCoordinator(EventCoordinator eventCoordinator){
        eventCoordinatorList.add(eventCoordinatorManager.createEventCoordinator(eventCoordinator));
    }

    public ObservableList<EventCoordinator> getAllEventCoordinators(){
        return eventCoordinatorList;
    }

    public void deleteEventCoordinator(EventCoordinator eventCoordinator){
        eventCoordinatorManager.deleteEventCoordinator(eventCoordinator);
        eventCoordinatorList.remove(eventCoordinator);
    }

    public EventCoordinator getWhoIsLogin(){
        return whoIsLogin;
    }

    public void setWhoIsLogin(EventCoordinator eventCoordinator){
        this.whoIsLogin = eventCoordinator;
    }
}
