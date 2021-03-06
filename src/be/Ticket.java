package be;

import javafx.beans.property.*;

/**
 * The Ticket class holds all the information that a ticket consist of, such as : ID, Event ID, Seat and Row if the event has seats,
 * Price, VIP status, The ticket owner(Customer), and the Event the ticket is for (Event)
 * Mikkel Theut
 */

public class Ticket {

    private StringProperty id = new SimpleStringProperty();
    private IntegerProperty eventId= new SimpleIntegerProperty();
    private StringProperty seat= new SimpleStringProperty();
    private StringProperty row= new SimpleStringProperty();
    private DoubleProperty price = new SimpleDoubleProperty();
    private BooleanProperty vip= new SimpleBooleanProperty();
    private BooleanProperty seated= new SimpleBooleanProperty();
    private Customer customer;
    private Event event;

    public Ticket(){}
    public Ticket(Customer customer, Event event, double price,boolean vip,boolean isSeated) {
        this.customer = customer;
        this.event = event;
        this.price.set(price);
        this.vip.set(vip);
        this.seated.set(isSeated);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Event getEvent(){
        return event;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setEvent(Event event) {
       this.event = event;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setRow(String row) {
        this.row.set(row);
    }

    public void setSeat(String seat) {
        this.seat.set(seat);
    }

    public boolean isVip() {
        return vip.get();
    }

    public void setVip(boolean vip) {
        this.vip.set(vip);
    }

    public void setSeated(boolean seated) {
        this.seated.set(seated);
    }

    public StringProperty getIdProperty() {
        return id;
    }

    public IntegerProperty getEventIdProperty() {
        return eventId;
    }

    public StringProperty getSeatProperty() {
        return seat;
    }

    public StringProperty getRowProperty() {
        return row;
    }

    public DoubleProperty getPriceProperty() {
        return price;
    }

    public BooleanProperty getVipProperty() {
        return vip;
    }

    public BooleanProperty getSeatedProperty() {
        return seated;
    }


}
