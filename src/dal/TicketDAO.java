package dal;

import be.Customer;
import be.Event;
import be.Ticket;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicketDAO {
    private DBConnecting dbc = new DBConnecting();

    public TicketDAO() throws IOException {
    }

    public Ticket createTicket(Ticket ticket) {
        try (Connection connection = dbc.getConnection()) {
            String sql = "INSERT INTO Ticket(ID, Customer_ID, Event_ID, Price, " +
                    " IsSeated, IsVIP, IsDrink, IsFood, Row, Seat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,  ?);";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, ticket.getIdProperty().get());
            ps.setInt(2, ticket.getCustomer().getIdProperty().get());
            ps.setInt(3, ticket.getEvent().getIdProperty().get());
            ps.setDouble(4, ticket.getPriceProperty().get());

            ps.setBoolean(5,ticket.getSeatedProperty().get());
            ps.setBoolean(6,ticket.getVipProperty().get());
            ps.setBoolean(7,ticket.getDrinksProperty().get());
            ps.setBoolean(8,ticket.getFoodProperty().get());

            ps.setString(9, ticket.getRowProperty().get());
            ps.setString(10, ticket.getSeatProperty().get());

            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ticket;
    }

    public Ticket updateTicket(Ticket ticket) {
        try (Connection connection = dbc.getConnection()) {
            String sql = "UPDATE Ticket SET Price, IsSeated, IsVIP, IsDrink," +
                    "IsFood, Row, Seat = (?, ?, ?, ?, ?, ?, ?, ?) WHERE ID = (?);";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, ticket.getPriceProperty().get());


            ps.setBoolean(3,ticket.getSeatedProperty().get());
            ps.setBoolean(4,ticket.getVipProperty().get());
            ps.setBoolean(5,ticket.getDrinksProperty().get());
            ps.setBoolean(6,ticket.getFoodProperty().get());

            ps.setString(7, ticket.getRowProperty().get());
            ps.setString(8, ticket.getSeatProperty().get());

            ps.setString(9, ticket.getIdProperty().get());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ticket;
    }

    public void deleteTicket(Ticket ticket) {
        String sql = "DELETE FROM Ticket WHERE ID = (?);";
        try (Connection connection = dbc.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ticket.getIdProperty().get());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Ticket> getTicketsFromEvent(Event event) {
        List<Ticket> allTicketsFromEvent = new ArrayList<>();
        try (Connection c = dbc.getConnection()) {
            String sql = "SELECT * FROM Ticket JOIN Customer ON ticket.Customer_ID = Customer.ID WHERE Event_ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, event.getIdProperty().get());
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                Customer customer;
                Ticket ticket = new Ticket();
                ticket.setId(rs.getString("ID"));
                ticket.setCustomer(customer = new Customer(rs.getString("Email"), rs.getString("FullName"), rs.getString("Telephone_Number")));
                customer.setId(rs.getInt("Customer_ID"));
                ticket.setEvent(event);
                ticket.setPrice(rs.getInt("Price"));

                ticket.setSeated(rs.getBoolean("IsSeated"));
                ticket.setVip(rs.getBoolean("IsVIP"));
                ticket.setDrinks(rs.getBoolean("IsDrink"));
                ticket.setFood(rs.getBoolean("IsFood"));
                ticket.setRow(rs.getString("Row"));
                ticket.setSeat(rs.getString("Seat"));

                allTicketsFromEvent.add(ticket);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allTicketsFromEvent;
    }

    public boolean foundTicketID(String id) {
        String sql = "Select ID FROM Ticket WHERE ID = (?)";
        try (Connection connection = dbc.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, id);
            ps.execute();

            ResultSet resultSet = ps.getResultSet();
            if(resultSet.next()){
                return Objects.equals(id, resultSet.getString("ID"));
            }else {

                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

}
