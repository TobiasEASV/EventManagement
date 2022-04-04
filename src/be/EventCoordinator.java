package be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EventCoordinator {

    private IntegerProperty ID =new SimpleIntegerProperty();
    private StringProperty fullName = new SimpleStringProperty();
    private StringProperty userName = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();

    public EventCoordinator(String fullName, String userName, String password) {
        this.fullName.set(fullName);
        this.userName.set(userName);
        this.password.set(password);
    }

    public IntegerProperty getIDProperty() {
        return ID;
    }

    public StringProperty getFullNameProperty() {
        return fullName;
    }

    public StringProperty getUserNameProperty() {
        return userName;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }
}
