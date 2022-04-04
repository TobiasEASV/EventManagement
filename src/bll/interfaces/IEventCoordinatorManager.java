package bll.interfaces;

import be.Event;
import be.EventCoordinator;

import java.util.List;

public interface IEventCoordinatorManager {

    public EventCoordinator checkCredential(String userName, String password);

    public EventCoordinator createEventCoordinator(EventCoordinator eventCoordinator);

    public List<EventCoordinator> getAllEventCoordinators();

    public void deleteEventCoordinator(EventCoordinator eventCoordinator);

}
