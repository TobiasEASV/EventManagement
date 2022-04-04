package gui.model;
import be.Event;
import bll.interfaces.IEventManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class EventListModel {

    private ObservableList<Event> eventList = FXCollections.observableArrayList();
    private IEventManager eventManager;


    public EventListModel(IEventManager eventManager){
        this.eventManager = eventManager;
        eventList.addAll(this.eventManager.getAllEvents());
    }

    public ObservableList<Event> getEventList(){
        return eventList;
    }

    public void deleteEventFromList(Event event){
        eventManager.deleteEvent(event);
        eventList.remove(event);
    }
    public void setEventInactive(Event event)
    {
        eventManager.updateEvent(event);

    }

    public void createEvent(Event event){
        eventList.add(eventManager.createEvent(event));
    }

    public void updateEvent(Event updateEvent){
        eventManager.updateEvent(updateEvent);
        eventList.removeIf(event -> event.getIdProperty() == updateEvent.getIdProperty());
    }
}
