package dal;

import be.Event;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBEvent {

    private final DBConnecting dbConnecting;



    public DBEvent() throws IOException {
        dbConnecting = new DBConnecting();
    }

    public Event createEvent(Event event){

        try(Connection connection = dbConnecting.getConnection()){
            String sql = "INSERT INTO [Event](Title, Artist, Description, Location, Price, VIP_Price, Food_Price, Drink_Price, Contact_Mail, Start_Data, End_Data) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getTitleProperty().get());
            preparedStatement.setString(2, event.getArtistsProperty().get());
            preparedStatement.setString(3, event.getDescriptionProperty().get());
            preparedStatement.setString(4, event.getLocationProperty().get());
            preparedStatement.setDouble(5, event.getPriceProperty().get());
            preparedStatement.setDouble(6, event.getVipPriceProperty().get());
            preparedStatement.setDouble(7, event.getFoodPriceProperty().get());
            preparedStatement.setDouble(8, event.getDrinkPriceProperty().get());
            preparedStatement.setString(9, event.getContactEmailProperty().get());
            preparedStatement.setObject(10, event.getStartDateProperty().get());
            preparedStatement.setObject(11, event.getEndDateProperty().get());


            //Extract data from DB
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                event.setId(id);
            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
        }
        return event;
    }

    public List<Event> getAllEvents(){

        List<Event> allEvents = new ArrayList<>();

        try(Connection connection = dbConnecting.getConnection()){
            String sql = "SELECT * FROM Event";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //Extract data from DB

            if(preparedStatement.execute()) {
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String artist = resultSet.getString(3);
                    String description = resultSet.getString(4);
                    String location = resultSet.getString(5);
                    double price = resultSet.getDouble(6);
                    String contact_Mail = resultSet.getString(7);
                    Date start_Data = resultSet.getDate(8);
                    Date end_Data = resultSet.getDate(9);
                    double VIPPrice = resultSet.getDouble(10);
                    double drinkPrice = resultSet.getDouble(11);
                    double foodPrice = resultSet.getDouble(12);

                    Event event = new Event(title, description, location, artist, contact_Mail, price, VIPPrice, foodPrice, drinkPrice, LocalDate.parse(start_Data.toString()), LocalDate.parse(end_Data.toString()));
                    event.setId(id);
                    allEvents.add(event);
                }
            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
        }
        return allEvents;



    }
}
