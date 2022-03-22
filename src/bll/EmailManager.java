package bll;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.DBEmail;

import java.io.IOException;
import java.util.HashMap;

public class EmailManager {

        DBEmail dbEmail;
        private HashMap<String,String> cache =  new HashMap<>();

    public EmailManager() throws IOException {
        dbEmail = new DBEmail();
    }

    public HashMap<String,String> getCredentials(){
        if(cache.isEmpty()){
            cache = dbEmail.getCredentials();
        }
        return cache;
    }


    public void updateCredentials(String email, String password) throws SQLServerException {

        dbEmail.setCredentials(email, hashString(password));
    }

    public String hashString(String textToHash){
        return textToHash;
    }

}
