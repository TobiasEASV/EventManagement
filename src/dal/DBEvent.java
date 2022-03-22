package dal;

import be.Event;

import java.io.IOException;
import java.sql.*;

public class DBEvent {

    private final DBConnecting dbConnecting;



    public DBEvent() throws IOException {
        dbConnecting = new DBConnecting();
    }

    public Event createEvent(Event event){

        try(Connection connection = dbConnecting.getConnection()){
            String sql = "INSERT INTO Event(Title, Artist, Description, Location, Price, Contact_Mail, Start_Data, End_Data) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getTitleProperty().get());
            preparedStatement.setString(2, event.getArtistsProperty().get());
            preparedStatement.setString(3, event.getDescriptionProperty().get());
            preparedStatement.setString(4, event.getLocationProperty().get());
            preparedStatement.setDouble(5, event.getPriceProperty().get());
            preparedStatement.setString(6, event.getContactEmailProperty().get());
            preparedStatement.setObject(7, event.getStartDateProperty().get());
            preparedStatement.setObject(8, event.getEndDateProperty().get());


            //Extract data from DB
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
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
