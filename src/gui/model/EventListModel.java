package gui.model;

import be.Event;

import bll.interfaces.IEventManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.time.LocalDate;

public class EventListModel {

    private ObservableList<Event> eventList = FXCollections.observableArrayList();
    private IEventManager eventManager;


    public EventListModel(IEventManager eventManager){
        this.eventManager = eventManager;
        eventList.add(new Event("tobias","ttt","sdælgj", "sdj", "sdkljf", 44, 34, LocalDate.now(), LocalDate.now()));
        eventList.add(new Event("tobias333","ttt","sdælgj", "sdj", "sdkljf", 44, 34, LocalDate.now(), LocalDate.now()));
        eventList.add(new Event("tobias555","ttt","sdælgj", "sdj", "sdkljf", 44, 34, LocalDate.now(), LocalDate.now()));
        eventList.add(new Event("tobias66","ttt","sdælgj", "sdj", "sdkljf", 44, 34, LocalDate.now(), LocalDate.now()));
        //eventList.addAll(this.eventManager.getAllEvents());
    }

    public ObservableList<Event> getEventList(){
        System.out.println("tesdtsdf");
        return eventList;
    }

    public void deleteEventFromList(Event event){
        eventManager.deleteEvent(event);
        eventList.remove(event);
    }

    public void createEvent(Event event){
        System.out.println(event.getTitleProperty());
        Event event1 = eventManager.createEvent(event);
        System.out.println(event1.getTitleProperty());
        eventList.add(eventManager.createEvent(event));
    }

    public void updateEvent(Event updateEvent){
        eventManager.updateEvent(updateEvent);
        eventList.removeIf(event -> event.getIdProperty() == updateEvent.getIdProperty());
    }



}
