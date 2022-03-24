package dal;

import be.Event;
import com.microsoft.sqlserver.jdbc.SQLServerException;

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

    public Event createEvent(Event event) {

        try (Connection connection = dbConnecting.getConnection()) {
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
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                event.setId(id);
            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
        }
        return event;
    }

    public List<Event> getAllEvents() {

        List<Event> allEvents = new ArrayList<>();

        try (Connection connection = dbConnecting.getConnection()) {
            String sql = "SELECT * FROM Event";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //Extract data from DB

            if (preparedStatement.execute()) {
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String title = resultSet.getString("Title");
                    String artist = resultSet.getString("Artist");
                    String description = resultSet.getString("Description");
                    String location = resultSet.getString("Location");
                    double price = resultSet.getDouble("Price");
                    String contact_Mail = resultSet.getString("Contact_Mail");
                    Date start_Data = resultSet.getDate("Start_Data");
                    Date end_Data = resultSet.getDate("End_Data");
                    double VIPPrice = resultSet.getDouble("VIP_Price");
                    double drinkPrice = resultSet.getDouble("Drink_Price");
                    double foodPrice = resultSet.getDouble("Food_Price");

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

    public void deleteEvent(Event event) {
        String sql = "DELETE FROM Event WHERE ID = (?);";
        try (Connection connection = dbConnecting.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, event.getIdProperty().get());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public Event updateEvent(Event event) {
        try (Connection connection = dbConnecting.getConnection()) {
            String sql = "UPDATE [Event] SET Title =(?), Artist =(?), Description=(?), Location=(?), Price=(?), VIP_Price=(?), Food_Price=(?), Drink_Price=(?), Contact_Mail=(?), Start_Data=(?), End_Data=(?) WHERE Id = (?)";
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
            preparedStatement.setInt(12, event.getIdProperty().get());


            //Extract data from DB
            preparedStatement.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return event;
    }
}
