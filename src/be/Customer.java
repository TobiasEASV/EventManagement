package be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This is the Customer Class, holds all the information of a customer, such as : Name, Email, ID, Telephone number.
 */
public class Customer {
    private StringProperty name = new SimpleStringProperty();
    private StringProperty email= new SimpleStringProperty();
    private IntegerProperty id  = new SimpleIntegerProperty();
    private StringProperty telephoneNumber= new SimpleStringProperty();

    /**
     * The constructor needs an Email, a name and a telephone number.
     * @param email
     * @param name
     * @param telephoneNumber
     */
    public Customer(String email, String name, String telephoneNumber) {
        this.name.set(name);
        this.email.set(email);
        this.telephoneNumber.set(telephoneNumber);
    }

    /**
     * Returns the customer IDproperty
     * @return
     */
    public IntegerProperty getIdProperty(){
        return id;
    }

    /**
     * Sets the customer ID, must be an integer.
     * @param id
     */
    public void setId(int id) {
        this.id.set(id);
    }

    /**
     * Returns the name property of the Customer.
     * @return
     */
    public StringProperty getNameProperty() {
        return name;
    }

    /**
     * Sets the name of the Customer, must be a string.
     * @param name
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * Returns the Email property of the Customer.
     * @return
     */
    public StringProperty getEmailProperty() {
        return email;
    }

    /**
     * Sets the Email of the customer.
     * @param email
     */
    public void setEmail(String email) {
        this.email.set(email);
    }

    /**
     * Returns the telephone number property of a customer.
     * @return
     */
    public StringProperty getTelephoneNumberProperty() {
        return telephoneNumber;
    }

    /**
     * Sets the telephone number of a customer.
     * @param telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber.set(telephoneNumber);
    }
}
