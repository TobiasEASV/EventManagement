package be;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Event {

    private StringProperty title = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private StringProperty location = new SimpleStringProperty();
    private StringProperty artists = new SimpleStringProperty();
    private StringProperty contactEmail = new SimpleStringProperty();

    private DoubleProperty price = new SimpleDoubleProperty();
    private DoubleProperty vipPrice = new SimpleDoubleProperty();
    private DoubleProperty foodPrice = new SimpleDoubleProperty();
    private DoubleProperty drinkPrice = new SimpleDoubleProperty();

    private IntegerProperty id = new SimpleIntegerProperty();

    private LocalDate startDate;
    private LocalDate endDate;

    public Event (String title, String description, String location, String artist, String contactEmail, double price, double vipPrice, double foodPrice, double drinkPrice, int id, LocalDate startDate, LocalDate endDate)
    {
        this.title.set(title);
        this.description.set(description);
        this.location.set(location);
        this.artists.set(artist);
        this.contactEmail.set(contactEmail);
        this.price.set(price);
        this.vipPrice.set(vipPrice);
        this.foodPrice.set(foodPrice);
        this.drinkPrice.set(drinkPrice);
        this.id.set(id);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getLocation() {
        return location.get();
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getDrinkPrice() {
        return drinkPrice.get();
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice.set(drinkPrice);
    }

    public double getFoodPrice() {
        return foodPrice.get();
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice.set(foodPrice);
    }

    public String getArtists() {
        return artists.get();
    }

    public void setArtists(String artists) {
        this.artists.set(artists);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getVipPrice() {
        return vipPrice.get();
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice.set(vipPrice);
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail.set(contactEmail);
    }

    public String getContactEmail() {
        return contactEmail.get();
    }
}
