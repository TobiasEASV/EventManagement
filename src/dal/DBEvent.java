package dal;

import be.Event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBEvent {

    private final DBConnecting dbConnecting;



    public DBEvent() throws IOException {
        dbConnecting = new DBConnecting();
    }

    public Event createEvent(Event event){

        try(Connection connection = dbConnecting.getConnection()){
            String sql = "INSERT INTO Event(Title, Artist, Description, Location, Price, Contact_Mail, Start_Data, End_Data) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, event.titleProperty().get());
            preparedStatement.setString(2, event.artistsProperty().get());
            preparedStatement.setString(3, event.descriptionProperty().get());
            preparedStatement.setString(4, event.locationProperty().get());
            preparedStatement.setDouble(5, event.priceProperty().get());
            preparedStatement.setString(6, event.contactEmailProperty().get());
            preparedStatement.setObject(7, event.startDateProperty().get());
            preparedStatement.setObject(8, event.endDateProperty().get());


            //Extract data from DB
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                int id = resultSet.getInt("ID");
                event.setId(id);
            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
        }
        return event;
    }
}
