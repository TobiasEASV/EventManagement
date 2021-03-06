package be;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The event class holds all the information of an event, such as: ID, Title, Description, Location, Artist, Contact Email,
 * Price, VIPPrice, Event state(Active/Inactive), Start Date, End Date.
 */
public class Event {

    private StringProperty title = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private StringProperty location = new SimpleStringProperty();
    private StringProperty artists = new SimpleStringProperty();
    private StringProperty contactEmail = new SimpleStringProperty();

    private DoubleProperty price = new SimpleDoubleProperty();
    private DoubleProperty vipPrice = new SimpleDoubleProperty();

    private BooleanProperty isActive = new SimpleBooleanProperty();

    private IntegerProperty id = new SimpleIntegerProperty();

    private ObjectProperty<LocalDateTime> startDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> endDate = new SimpleObjectProperty<>();


    public Event (String title, String description, String location, String artist, String contactEmail, double price, double vipPrice,  LocalDateTime startDate, LocalDateTime endDate, boolean isActive)
    {
        this.title.set(title);
        this.description.set(description);
        this.location.set(location);
        this.artists.set(artist);
        this.contactEmail.set(contactEmail);
        this.price.set(price);
        this.vipPrice.set(vipPrice);
        this.isActive.set(isActive);
        this.startDate.set(startDate);
        this.endDate.set(endDate);
    }
    public void setDescription(String description) {
        this.description.set(description);
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public void setIsActive(boolean isActive) {
        this.isActive.set(isActive);
    }
    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setId(int id) {
        this.id.set(id);
    }
    
    public ObjectProperty<LocalDateTime> getEndDateProperty() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate.set(endDate);
    }

    public ObjectProperty<LocalDateTime> getStartDateProperty() {
        return startDate;
    }
    
    public void setStartDate(LocalDateTime startDate) {
        this.startDate.set(startDate);
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

    public BooleanProperty getIsActiveProperty() {
        return isActive;
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

    public IntegerProperty getIdProperty() {
        return id;
    }

    @Override
    public String toString() {
        return  title.get();
    }
}
