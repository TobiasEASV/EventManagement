package be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private StringProperty name = new SimpleStringProperty();
    private StringProperty email= new SimpleStringProperty();
    private IntegerProperty id  = new SimpleIntegerProperty();
    private StringProperty telephoneNumber= new SimpleStringProperty();

    public Customer(String email, String name, String telephoneNumber) {
        this.name.set(name);
        this.email.set(email);
        this.telephoneNumber.set(telephoneNumber);
    }

    public IntegerProperty getIdProperty(){
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty getEmailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }


    public StringProperty getTelephoneNumberProperty() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber.set(telephoneNumber);
    }
}
