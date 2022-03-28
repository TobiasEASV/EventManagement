package be;

import javafx.beans.property.*;

/**
 * Ticket class
 * Mikkel Theut
 */

public class Ticket {


    //private StringProperty customerName= new SimpleStringProperty();
    //private StringProperty customerEmail= new SimpleStringProperty();
    private StringProperty paymentStatus= new SimpleStringProperty();

    private IntegerProperty id = new SimpleIntegerProperty();
    //private IntegerProperty customerId= new SimpleIntegerProperty();
    private IntegerProperty eventId= new SimpleIntegerProperty();
    private StringProperty seat= new SimpleStringProperty();
    private StringProperty row= new SimpleStringProperty();

    private DoubleProperty price = new SimpleDoubleProperty();

    private BooleanProperty vip= new SimpleBooleanProperty();
    private BooleanProperty drinks= new SimpleBooleanProperty();
    private BooleanProperty food= new SimpleBooleanProperty();
    private BooleanProperty seated= new SimpleBooleanProperty();

    private Customer customer;
    private Event event;

    private final String paid = "Paid";
    private final String notPaid = "Not Paid";


    public Ticket() {}

    public Ticket(Customer customer, Event event, double price,boolean vip, boolean drinks, boolean food, boolean isSeated) {
        this.customer = customer;
        this.event = event;
        this.price.set(price);

        this.vip.set(vip);
        this.drinks.set(drinks);
        this.food.set(food);
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

    public void setId(int id) {
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

    public void setFood(boolean food) {
        this.food.set(food);
    }

    public void setDrinks(boolean drinks) {
        this.drinks.set(drinks);
    }

    public IntegerProperty getIdProperty() {
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

    public BooleanProperty getDrinksProperty() {
        return drinks;
    }

    public BooleanProperty getFoodProperty() {
        return food;
    }

    public BooleanProperty getSeatedProperty() {
        return seated;
    }

    public StringProperty getPaymentStatusProperty() {
        return paymentStatus;
    }

}
