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

    public Ticket(String customerName, String customerEmail, int seat, int row, double price, boolean isPaid,boolean vip, boolean drinks, boolean food, boolean isSeated)
    {
        this.customerName.set(customerName);
        this.customerEmail.set(customerEmail);
        this.seat.set(seat);
        this.row.set(row);
        this.price.set(price);
        this.isPaid.set(isPaid);
        this.vip.set(vip);
        this.drinks.set(drinks);
        this.food.set(food);
        this.seated.set(isSeated);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getCustomerId() {
        return customerId.get();
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public int getEventId() {
        return eventId.get();
    }

    public void setEventId(int eventId) {
        this.eventId.set(eventId);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getRow() {
        return row.get();
    }

    public void setRow(int row) {
        this.row.set(row);
    }

    public int getSeat() {
        return seat.get();
    }

    public void setSeat(int seat) {
        this.seat.set(seat);
    }

    public String getCustomerEmail() {
        return customerEmail.get();
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail.set(customerEmail);
    }

    public String getCustomerName() {
        return customerName.get();
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

    public boolean isPaid() {
        return isPaid.get();
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid.set(isPaid);
    }

    public boolean isSeated() {
        return seated.get();
    }

    public void setSeated(boolean seated) {
        this.seated.set(seated);
    }

    public boolean isFood() {
        return food.get();
    }

    public void setFood(boolean food) {
        this.food.set(food);
    }

    public boolean isDrinks() {
        return drinks.get();
    }

    public void setDrinks(boolean drinks) {
        this.drinks.set(drinks);
    }
}
