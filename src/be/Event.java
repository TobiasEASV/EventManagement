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

    private ObjectProperty<LocalDate> startDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> endDate = new SimpleObjectProperty<>();


    public Event (String title, String description, String location, String artist, String contactEmail, double price, double vipPrice, double foodPrice, double drinkPrice, LocalDate startDate, LocalDate endDate)
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
    
    public ObjectProperty<LocalDate> getEndDateProperty() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate.set(endDate);
    }

    public ObjectProperty<LocalDate> getStartDateProperty() {
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


    public StringProperty getTitleProperty() {
        return title;
    }

    public StringProperty getDescriptionProperty() {
        return description;
    }

    public StringProperty getLocationProperty() {
        return location;
    }

    public StringProperty getArtistsProperty() {
        return artists;
    }

    public StringProperty getContactEmailProperty() {
        return contactEmail;
    }

    public DoubleProperty getPriceProperty() {
        return price;
    }

    public DoubleProperty getVipPriceProperty() {
        return vipPrice;
    }

    public DoubleProperty getFoodPriceProperty() {
        return foodPrice;
    }

    public DoubleProperty getDrinkPriceProperty() {
        return drinkPrice;
    }

    public IntegerProperty getIdProperty() {
        return id;
    }
}
