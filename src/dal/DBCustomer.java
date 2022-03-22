package dal;

import be.Customer;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;

public class DBCustomer {

    private DBConnecting dbConnecting;

    public DBCustomer() throws IOException {
        dbConnecting = new DBConnecting();
    }

    public void createCustomer(Customer customer)
    {
        String sql= "INSERT INTO [Customer] (FullName, Email) VALUES (?,?)";
        try (Connection connection = dbConnecting.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            if(ps.executeUpdate() == 1)
            {
                ResultSet resultSet = ps.getGeneratedKeys();
                if (resultSet.next())
                {
                    int id = resultSet.getInt(1);
                    customer.setId(id);
                }
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
