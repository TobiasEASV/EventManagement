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


    public Ticket()
    {

    }

    public Ticket(Customer customer, int seat, int row, double price, boolean isPaid,boolean vip, boolean drinks, boolean food, boolean isSeated)
    {
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

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public StringProperty customerEmailProperty() {
        return customerEmail;
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public IntegerProperty customerIdProperty() {
        return customerId;
    }

    public IntegerProperty eventIdProperty() {
        return eventId;
    }

    public IntegerProperty seatProperty() {
        return seat;
    }

    public IntegerProperty rowProperty() {
        return row;
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public boolean isIsPaid() {
        return isPaid.get();
    }

    public BooleanProperty isPaidProperty() {
        return isPaid;
    }

    public BooleanProperty vipProperty() {
        return vip;
    }

    public BooleanProperty drinksProperty() {
        return drinks;
    }

    public BooleanProperty foodProperty() {
        return food;
    }

    public BooleanProperty seatedProperty() {
        return seated;
    }
}
