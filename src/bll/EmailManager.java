package bll;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.DBEmail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmailManager {

        DBEmail dbEmail;
        private List<String> cccc =  new ArrayList<>();

    public EmailManager() throws IOException {
        dbEmail = new DBEmail();
    }

    public List<String> getCredentials(){
        if(cccc.isEmpty()){
            cccc = dbEmail.getCredentials();
        }
        return cccc;
    }

    public void updateCredentials(String email, String password) throws SQLServerException {

        dbEmail.setCredentials(email, hashString(password));
    }

    public String hashString(String textToHash){
        return textToHash;
    }

}
