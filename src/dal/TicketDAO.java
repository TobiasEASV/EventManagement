package dal;

import be.Ticket;

import java.io.IOException;
import java.sql.*;

public class TicketDAO {
    private DBConnecting dbc = new DBConnecting();

    public TicketDAO() throws IOException {
    }

    public Ticket createTicket(Ticket ticket) {
        try (Connection connection = dbc.getConnection()) {
            String sql = "INSERT INTO Ticket(Customer_ID, Event_ID, Price, IsPaid," +
                    " IsSeated, IsVIP, IsDrink, IsFood, Row, Seat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ticket.getCustomerIdProperty().get());
            ps.setInt(2, ticket.getEventIdProperty().get());
            ps.setDouble(3, ticket.getPriceProperty().get());

            byte isTicketPaidBit = 0;
            if (ticket.getIsPaidProperty().get())
                isTicketPaidBit = 1;
            ps.setByte(4, isTicketPaidBit);

            byte isTicketSeatedBit = 0;
            if (ticket.getSeatedProperty().get())
                isTicketSeatedBit = 1;
            ps.setByte(5, isTicketSeatedBit);

            byte isTicketVIPBit = 0;
            if (ticket.getVipProperty().get())
                isTicketVIPBit = 1;
            ps.setByte(6, isTicketVIPBit);

            byte isTicketDrinkBit = 0; //this variable might be drunk?
            if (ticket.getDrinksProperty().get())
                isTicketDrinkBit = 1;
            ps.setByte(7, isTicketDrinkBit);

            byte isTicketFoodBit = 0;
            if (ticket.getFoodProperty().get())
                isTicketFoodBit = 1;
            ps.setByte(8, isTicketFoodBit);

            if (ticket.getSeatedProperty().get()) {
            ps.setInt(9, ticket.getRowProperty().get());
            ps.setInt(10, ticket.getSeatProperty().get());
            }

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
        return ticket;
    }


    public Ticket updateTicket(Ticket ticket) {
        try(Connection connection = dbc.getConnection())
        {
            String sql = "UPDATE Ticket SET Price, IsPaid, IsSeated, IsVIP, IsDrink," +
                    "IsFood, Row, Seat = (?, ?, ?, ?, ?, ?, ?, ?) WHERE ID = (?);";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, ticket.getPriceProperty().get());

            byte isTicketPaidBit = 0;
            if (ticket.getIsPaidProperty().get())
                isTicketPaidBit = 1;
            ps.setByte(2, isTicketPaidBit);

            byte isTicketSeatedBit = 0;
            if (ticket.getSeatedProperty().get())
                isTicketSeatedBit = 1;
            ps.setByte(3, isTicketSeatedBit);

            byte isTicketVIPBit = 0;
            if (ticket.getVipProperty().get())
                isTicketVIPBit = 1;
            ps.setByte(4, isTicketVIPBit);

            byte isTicketDrinkBit = 0; //this variable might be drunk?
            if (ticket.getDrinksProperty().get())
                isTicketDrinkBit = 1;
            ps.setByte(5, isTicketDrinkBit);

            byte isTicketFoodBit = 0;
            if (ticket.getFoodProperty().get())
                isTicketFoodBit = 1;
            ps.setByte(6, isTicketFoodBit);

            if (ticket.getSeatedProperty().get()) {
                ps.setInt(7, ticket.getRowProperty().get());
                ps.setInt(8, ticket.getSeatProperty().get());
            }

            ps.setInt(9, ticket.getIdProperty().get());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ticket;
    }

    public void deleteTicket(Ticket ticket) {
        String sql = "DELETE FROM Ticket WHERE ID = (?);";
        try(Connection connection = dbc.getConnection())
        {
            PreparedStatement ps =connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ticket.getIdProperty().get());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Ticket getAllTickets() {
        return null;
    }


}
