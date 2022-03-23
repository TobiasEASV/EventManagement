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
        String sql= "INSERT INTO [Customer] (FullName, Email) VALUES (?,?);";
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
    public Customer getCustomer(Customer customer)
    {
        String sql= "SELECT * FROM Customer WHERE ID = (?);";
        try(Connection connection = dbConnecting.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.getId());
            ResultSet rs = ps.getGeneratedKeys();
            int id = rs.getInt(1);
            String customerName = rs.getString(2);
            String customerEmail = rs.getString(3);
            Customer customer1 = new Customer(customerEmail, customerName);
            customer1.setId(id);
            return customer1;

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void updateCustomer(Customer customer)
    {
        String sql = "UPDATE Customer SET FullName, Email = (?,?) WHERE ID = (?);";
        try(Connection connection = dbConnecting.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setInt(3, customer.getId());
            ps.executeUpdate();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteCustomer(Customer customer)
    {
        String sql = "DELETE FROM Customer WHERE ID = (?);";
        try(Connection connection = dbConnecting.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.getId());
            ps.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}