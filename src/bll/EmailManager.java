package bll;

import be.Email;
import bll.interfaces.IEmailManager;
import dal.interfaces.IDatabaseFacade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class EmailManager implements IEmailManager {

    private IDatabaseFacade iDatabaseFacade;

    private final String PROP_FILE = ".data/email.settings";

    private HashMap<String,String> cache =  new HashMap<>();

    public EmailManager(IDatabaseFacade iDatabaseFacade){
        this.iDatabaseFacade = iDatabaseFacade;
    }

    @Override
    public Email getCredentials() throws IOException {
        Properties emailCredentials = new Properties();
        emailCredentials.load(new FileInputStream(PROP_FILE));
        final String emailName = emailCredentials.getProperty("Email");
        final String password = emailCredentials.getProperty("Password");

        return new Email(emailName,password);
    }

    @Override
    public boolean checkCredentials(Email email) throws IOException {
        Email emailFromFile = getCredentials();

        return email.getEmailNameProperty().get().equals(emailFromFile.getEmailNameProperty().get()) &&
                email.getPasswordProperty().get().equals(emailFromFile.getPasswordProperty().get());
    }

    @Override
    public void updateCredentials(Email email) {
    }
}
