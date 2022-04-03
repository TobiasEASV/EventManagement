package dal;

import be.Admin;
import be.EventCoordinator;
import dal.interfaces.IDBAdminDAO;

import java.sql.*;

public class DBAdminDAO implements IDBAdminDAO {

    private DBConnecting dbConnecting;

    public DBAdminDAO(DBConnecting dbConnecting) {
        this.dbConnecting = dbConnecting;
    }

    @Override
    public Admin checkCredential(String userName, String password) {
        Admin admin = null;
        try (Connection connection = dbConnecting.getConnection()) {
            String sql = "SELECT * FROM [Admin] WHERE UserID = (?) AND Password = (?)";
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
                admin = new Admin(fullName, userID, userPassword);
                admin.setID(id);

            }

        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
            return null;
        }
        return admin;
    }
}
