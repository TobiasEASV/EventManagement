package dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DBEmail {

    DBConnecting dbConnecting;



    public DBEmail() throws IOException {
        dbConnecting = new DBConnecting();
    }

    public HashMap<String,String> getCredentials(){

        final HashMap<String,String> credentials = new HashMap<>();

        try(Connection connection = dbConnecting.getConnection()){
            String sql = "Select EmailCredentials, PasswordCredentials FROM Email";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Extract data from DB
            preparedStatement.execute();

             ResultSet resultSet = preparedStatement.getResultSet();
             if(resultSet.next()){
                 String email = resultSet.getString("EmailCredentials");
                 String password = resultSet.getString("PasswordCredentials");
                 credentials.put("Email", email);
                 credentials.put("Password", password);
             }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
        }
        return credentials;

    }

    public void setCredentials(String email, String password) throws SQLServerException {

        try(Connection connection = dbConnecting.getConnection()){
            String sql = "UPDATE Email SET EmailCredentials = ?, PasswordCredentials = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            //Extract data from DB
            preparedStatement.executeUpdate();

            } catch (SQLException SQLe) {
            SQLe.printStackTrace();
        }

    }

}
