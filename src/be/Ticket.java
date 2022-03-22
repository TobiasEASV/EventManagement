package be;

import javafx.beans.property.*;

/**
 * Ticket class
 * Mikkel Theut
 */

public class Ticket {


    private StringProperty customerName= new SimpleStringProperty();
    private StringProperty customerEmail= new SimpleStringProperty();

    private IntegerProperty id = new SimpleIntegerProperty();
    private IntegerProperty customerId= new SimpleIntegerProperty();
    private IntegerProperty eventId= new SimpleIntegerProperty();
    private IntegerProperty seat= new SimpleIntegerProperty();
    private IntegerProperty row= new SimpleIntegerProperty();

    private DoubleProperty price = new SimpleDoubleProperty();

    private BooleanProperty isPaid = new SimpleBooleanProperty();
    private BooleanProperty vip= new SimpleBooleanProperty();
    private BooleanProperty drinks= new SimpleBooleanProperty();
    private BooleanProperty food= new SimpleBooleanProperty();
    private BooleanProperty seated= new SimpleBooleanProperty();

    private Customer customer;

    public Ticket()
    {

    }

    public Ticket(Customer customer, int seat, int row, double price, boolean isPaid,boolean vip, boolean drinks, boolean food, boolean isSeated)
    {
        this.customer = customer;
        this.customerName.set(customer.getCustomerName());
        this.customerEmail.set(customer.getCustomerEmail());
        this.seat.set(seat);
        this.row.set(row);
        this.price.set(price);
        this.isPaid.set(isPaid);
        this.vip.set(vip);
        this.drinks.set(drinks);
        this.food.set(food);
        this.seated.set(isSeated);
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }



    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }


    public void setEventId(int eventId) {
        this.eventId.set(eventId);
    }



    public void setId(int id) {
        this.id.set(id);
    }



    public void setRow(int row) {
        this.row.set(row);
    }



    public void setSeat(int seat) {
        this.seat.set(seat);
    }


    public void setCustomerEmail(String customerEmail) {
        this.customerEmail.set(customerEmail);
    }



    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public boolean isVip() {
        return vip.get();
    }

    public void setVip(boolean vip) {
        this.vip.set(vip);
    }
    

    public void setIsPaid(boolean isPaid) {
        this.isPaid.set(isPaid);
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

    public StringProperty getCustomerNameProperty() {
        return customerName;
    }

    public StringProperty getCustomerEmailProperty() {
        return customerEmail;
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public IntegerProperty getCustomerIdProperty() {
        return customerId;
    }

    public IntegerProperty getEventIdProperty() {
        return eventId;
    }

    public IntegerProperty getSeatProperty() {
        return seat;
    }

    public IntegerProperty getRowProperty() {
        return row;
    }

    public DoubleProperty getPriceProperty() {
        return price;
    }

    public BooleanProperty getIsPaidProperty() {
        return isPaid;
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
}
