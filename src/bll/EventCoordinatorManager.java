package bll;

import be.EventCoordinator;
import bll.interfaces.IEventCoordinatorManager;
import dal.interfaces.IDatabaseFacade;
import javafx.scene.control.Alert;

import java.util.List;

public class EventCoordinatorManager implements IEventCoordinatorManager {

    private IDatabaseFacade databaseFacade;

    public EventCoordinatorManager(IDatabaseFacade databaseFacade) {
        this.databaseFacade = databaseFacade;
    }

    @Override
    public EventCoordinator checkCredential(String userName, String password) {
        EventCoordinator eventCoordinator = databaseFacade.checkCredentialForEventCoordinator(userName, password);
        if(eventCoordinator != null ){
            return eventCoordinator;
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setContentText("username or password is wrong");
            alert.showAndWait();
        }
        return null;
    }

    @Override
    public EventCoordinator createEventCoordinator(EventCoordinator eventCoordinator) {
        return databaseFacade.createEventCoordinator(eventCoordinator);
    }

    @Override
    public List<EventCoordinator> getAllEventCoordinators() {
        return databaseFacade.getAllEventCoordinators();
    }

    @Override
    public void deleteEventCoordinator(EventCoordinator eventCoordinator) {
        databaseFacade.deleteEventCoordinator(eventCoordinator);
    }
}
