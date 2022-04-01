package be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Email {

    private StringProperty emailName = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();

    public Email(String emailName, String password) {
        this.emailName.set(emailName);
        this.password.set(password);
    }

    public StringProperty getEmailNameProperty() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName.set(emailName);
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
