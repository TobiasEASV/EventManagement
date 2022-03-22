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



    private ObjectProperty<LocalDate> startDate;
    private ObjectProperty<LocalDate> endDate;



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
        this.startDate.set(startDate);
        this.endDate.set(endDate);
    }
    public void setDescription(String description) {
        this.description.set(description);
    }


    public void setLocation(String location) {
        this.location.set(location);
    }


    public void setTitle(String title) {
        this.title.set(title);
    }



    public void setId(int id) {
        this.id.set(id);
    }



    public ObjectProperty<LocalDate> endDateProperty() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate.set(endDate);
    }

    public ObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }


    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice.set(drinkPrice);
    }


    public void setFoodPrice(double foodPrice) {
        this.foodPrice.set(foodPrice);
    }


    public void setArtists(String artists) {
        this.artists.set(artists);
    }



    public void setPrice(double price) {
        this.price.set(price);
    }



    public void setVipPrice(double vipPrice) {
        this.vipPrice.set(vipPrice);
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail.set(contactEmail);
    }


    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public StringProperty locationProperty() {
        return location;
    }

    public StringProperty artistsProperty() {
        return artists;
    }

    public StringProperty contactEmailProperty() {
        return contactEmail;
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public DoubleProperty vipPriceProperty() {
        return vipPrice;
    }

    public DoubleProperty foodPriceProperty() {
        return foodPrice;
    }

    public DoubleProperty drinkPriceProperty() {
        return drinkPrice;
    }

    public IntegerProperty idProperty() {
        return id;
    }
}
