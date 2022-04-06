package dal;

import be.Event;
import dal.interfaces.IDBEventDAO;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBEventDAO implements IDBEventDAO {

    private DBConnecting dbConnecting;


    public DBEventDAO(DBConnecting dbConnecting) {
        this.dbConnecting = dbConnecting;
    }

    public Event createEvent(Event event) {

        try (Connection connection = dbConnecting.getConnection()) {
            String sql = "INSERT INTO [Event](Title, Artist, Description, Location, Price, VIP_Price, Contact_Mail, Start_Data, End_Data, Active) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getTitleProperty().get());
            preparedStatement.setString(2, event.getArtistsProperty().get());
            preparedStatement.setString(3, event.getDescriptionProperty().get());
            preparedStatement.setString(4, event.getLocationProperty().get());
            preparedStatement.setDouble(5, event.getPriceProperty().get());
            preparedStatement.setDouble(6, event.getVipPriceProperty().get());
            preparedStatement.setString(7, event.getContactEmailProperty().get());
            preparedStatement.setObject(8, event.getStartDateProperty().get());
            preparedStatement.setObject(9, event.getEndDateProperty().get());
            preparedStatement.setBoolean(10,event.getIsActiveProperty().get());


            //Extract data from DB
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                event.setId(id);
            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
            return null;
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
                    Timestamp start_Data = resultSet.getTimestamp("Start_Data");
                    Timestamp end_Data = resultSet.getTimestamp("End_Data");
                    double VIPPrice = resultSet.getDouble("VIP_Price");
                    boolean isActive = resultSet.getBoolean("Active");

                    Event event = new Event(title, description, location, artist, contact_Mail, price, VIPPrice, start_Data.toLocalDateTime(), end_Data.toLocalDateTime(), isActive);
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
            String sql = "UPDATE [Event] SET Title =(?), Artist =(?), Description=(?), Location=(?), Price=(?), VIP_Price=(?),  Contact_Mail=(?), Start_Data=(?), End_Data=(?), Active=(?) WHERE Id = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getTitleProperty().get());
            preparedStatement.setString(2, event.getArtistsProperty().get());
            preparedStatement.setString(3, event.getDescriptionProperty().get());
            preparedStatement.setString(4, event.getLocationProperty().get());
            preparedStatement.setDouble(5, event.getPriceProperty().get());
            preparedStatement.setDouble(6, event.getVipPriceProperty().get());
            preparedStatement.setString(7, event.getContactEmailProperty().get());
            preparedStatement.setObject(8, event.getStartDateProperty().get());
            preparedStatement.setObject(9, event.getEndDateProperty().get());
            preparedStatement.setBoolean(10,event.getIsActiveProperty().get());
            preparedStatement.setInt(11, event.getIdProperty().get());


            //Extract data from DB
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return event;
    }
}
