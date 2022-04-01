package dal;

import be.Email;
import dal.interfaces.IDBEmailDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class DBEmailDAO implements IDBEmailDAO {

    private DBConnecting dbConnecting;



    public DBEmailDAO(DBConnecting dbConnecting) {
        this.dbConnecting = dbConnecting;
    }

    @Override
    public Email getCredentials() {

        Email EmailCredentials = null;

        try(Connection connection = dbConnecting.getConnection()){
            String sql = "Select EmailCredentials, PasswordCredentials FROM Email";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Extract data from DB
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                String email = resultSet.getString("EmailCredentials");
                String password = resultSet.getString("PasswordCredentials");

                EmailCredentials = new Email(email,password);
            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
        }
        return EmailCredentials;
    }

    public void setCredentials(String email, String password){

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
