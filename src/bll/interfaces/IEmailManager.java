package bll.interfaces;

import be.Email;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface IEmailManager {

    public boolean checkCredentials(Email email) throws IOException;

    public Email getCredentials() throws IOException;

    public void updateCredentials(Email email);
}
