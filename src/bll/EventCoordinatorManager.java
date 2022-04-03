package bll;

import be.EventCoordinator;
import bll.interfaces.IEventCoordinatorManager;
import dal.interfaces.IDatabaseFacade;

import java.util.List;

public class EventCoordinatorManager implements IEventCoordinatorManager {

    private IDatabaseFacade databaseFacade;

    public EventCoordinatorManager(IDatabaseFacade databaseFacade) {
        this.databaseFacade = databaseFacade;
    }

    @Override
    public EventCoordinator checkCredential(String userName, String password) {
        return databaseFacade.checkCredentialForEventCoordinator(userName, password);
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
