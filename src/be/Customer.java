package be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private StringProperty name = new SimpleStringProperty();
    private StringProperty email= new SimpleStringProperty();
    private IntegerProperty id  = new SimpleIntegerProperty();


    public Customer(String email, String name) {
        this.name.set(name);
        this.email.set(email);
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
}
