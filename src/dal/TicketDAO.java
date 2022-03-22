package dal;

import be.Ticket;

import java.io.IOException;
import java.sql.*;

public class TicketDAO {
    private DBConnecting dbc = new DBConnecting();

    public TicketDAO() throws IOException {
    }

    public void createTicket(Ticket ticket) {
        try (Connection connection = dbc.getConnection()) {
            String sql = "INSERT INTO Ticket(Customer_ID, Event_ID, Price, IsPaid," +
                    " IsSeated, IsVIP, IsDrink, IsFood, Row, Seat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ticket.getCustomerIdProperty().get());
            ps.setInt(2, ticket.getEventIdProperty().get());
            ps.setDouble(3, ticket.getPriceProperty().get());
            byte bit = 0;
            if (ticket.getIsPaidProperty().get())
                bit = 1;
            ps.setByte(4, bit);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    ticket.setId(id);
                }
            }
            // wip ps.setByte(5, bit2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
    public void updateTicket(Ticket ticket) {
        String sql = "UPDATE Ticket SET Price, IsPaid = (?, ?) WHERE categoryId = (?);";
        try(Connection connection = DC.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
     */


    public void deleteTicket(Ticket ticket) {
    }



    public Ticket getAllTickets() {
        return null;
    }
}
