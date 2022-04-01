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



    private BooleanProperty isActive = new SimpleBooleanProperty();
    private IntegerProperty id = new SimpleIntegerProperty();

    private ObjectProperty<LocalDate> startDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> endDate = new SimpleObjectProperty<>();


    public Event (String title, String description, String location, String artist, String contactEmail, double price, double vipPrice,  LocalDate startDate, LocalDate endDate, boolean isActive)
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
    
    public ObjectProperty<LocalDate> getEndDateProperty() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate.set(LocalDate.from(endDate));
    }

    public ObjectProperty<LocalDate> getStartDateProperty() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate.set(LocalDate.from(startDate));
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
