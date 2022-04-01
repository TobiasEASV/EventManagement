package bll;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.DBEmailDAO;

import java.io.IOException;
import java.util.HashMap;

public class EmailManager {

        DBEmailDAO dbEmailDAO;
        private HashMap<String,String> cache =  new HashMap<>();

    public EmailManager() throws IOException {
        dbEmailDAO = new DBEmailDAO();
    }

    public HashMap<String,String> getCredentials(){
        if(cache.isEmpty()){
            cache = dbEmailDAO.getCredentials();
        }
        return cache;
    }


    public void updateCredentials(String email, String password) throws SQLServerException {

        dbEmailDAO.setCredentials(email, hashString(password));
    }

    public String hashString(String textToHash){
        return textToHash;
    }

}
