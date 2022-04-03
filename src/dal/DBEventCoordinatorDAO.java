package dal;

import be.EventCoordinator;
import dal.interfaces.IDBEventCoordinatorDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBEventCoordinatorDAO implements IDBEventCoordinatorDAO {

    private DBConnecting dbConnecting;

    public DBEventCoordinatorDAO(DBConnecting dbConnecting) {
        this.dbConnecting = dbConnecting;
    }

    @Override
    public EventCoordinator checkCredential(String userName, String password) {
        EventCoordinator eventCoordinator = null;
        try (Connection connection = dbConnecting.getConnection()) {
            String sql = "SELECT * FROM EventCoordinator WHERE UserID = (?) AND Password = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2, password);

            //Extract data from DB
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fullName = resultSet.getString("FullName");
                String userID = resultSet.getString("UserID");
                String userPassword = resultSet.getString("Password");
                eventCoordinator = new EventCoordinator(fullName, userID, userPassword);
                eventCoordinator.setID(id);

            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
            return null;
        }
        return eventCoordinator;
    }

    @Override
    public EventCoordinator createEventCoordinator(EventCoordinator eventCoordinator) {
        try (Connection connection = dbConnecting.getConnection()) {
            String sql = "INSERT INTO [EventCoordinator](FullName, UserID, Password) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, eventCoordinator.getFullNameProperty().get());
            preparedStatement.setString(2, eventCoordinator.getUserNameProperty().get());
            preparedStatement.setString(3, eventCoordinator.getPasswordProperty().get());

            //Extract data from DB
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                eventCoordinator.setID(id);
            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
            return null;
        }
        return eventCoordinator;
    }

    @Override
    public List<EventCoordinator> getAllEventCoordinators() {
        List<EventCoordinator> allEventCoordinators = new ArrayList<>();

        try (Connection connection = dbConnecting.getConnection()) {
            String sql = "SELECT * FROM EventCoordinator";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //Extract data from DB

            if (preparedStatement.execute()) {
                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String fullName = resultSet.getString("FullName");
                    String userID = resultSet.getString("UserID");
                    String userPassword = resultSet.getString("Password");

                    EventCoordinator eventCoordinator = new EventCoordinator(fullName, userID, userPassword);
                    eventCoordinator.setID(id);
                    allEventCoordinators.add(eventCoordinator);
                }
            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
        }
        return allEventCoordinators;
    }

    @Override
    public void deleteEventCoordinator(EventCoordinator eventCoordinator) {
        String sql = "DELETE FROM EventCoordinator WHERE ID = (?);";
        try (Connection connection = dbConnecting.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, eventCoordinator.getIDProperty().get());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
