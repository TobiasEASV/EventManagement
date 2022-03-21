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
            String sql = "INSERT INTO Ticket(Customer_ID, Event_ID, Price, IsPaid) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ticket.getCustomerId());
            ps.setInt(2, ticket.getEventId());
            ps.setDouble(3, ticket.getPrice());
            byte bit = 0;
            if (ticket.isPaid())
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void updateTicket(Ticket ticket) {
    }


    public void deleteTicket(Ticket ticket) {
    }



    public Ticket getAllTickets() {
        return null;
    }
}
