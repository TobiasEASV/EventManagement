package dal;

import be.Customer;
import be.Event;
import be.Ticket;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    private DBConnecting dbc = new DBConnecting();

    public TicketDAO() throws IOException {
    }

    public Ticket createTicket(Ticket ticket) {
        try (Connection connection = dbc.getConnection()) {
            String sql = "INSERT INTO Ticket(Customer_ID, Event_ID, Price, IsPaid," +
                    " IsSeated, IsVIP, IsDrink, IsFood, Row, Seat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            System.out.println(" customer id on Ticket " + ticket.getCustomer().getIdProperty());


            ps.setInt(1, ticket.getCustomer().getIdProperty().get());
            ps.setInt(2, ticket.getEvent().getIdProperty().get());
            ps.setDouble(3, ticket.getPriceProperty().get());


            System.out.println(ticket.getRowProperty());

            ps.setBoolean(4,ticket.getIsPaidProperty().get());
            ps.setBoolean(5,ticket.getSeatedProperty().get());
            ps.setBoolean(6,ticket.getVipProperty().get());
            ps.setBoolean(7,ticket.getDrinksProperty().get());
            ps.setBoolean(8,ticket.getFoodProperty().get());

            ps.setString(9, ticket.getRowProperty().get());
            ps.setString(10, ticket.getSeatProperty().get());


            if ( ps.execute()) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt("ID");
                    ticket.setId(id);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ticket;
    }

    private byte BITConverter(boolean isTrue){
        if(isTrue){
            return 1;
        }else return 0;
    }


    public Ticket updateTicket(Ticket ticket) {
        try (Connection connection = dbc.getConnection()) {
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

            ps.setString(7, ticket.getRowProperty().get());
            ps.setString(8, ticket.getSeatProperty().get());


            ps.setInt(9, ticket.getIdProperty().get());
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
            ps.setInt(1, ticket.getIdProperty().get());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Ticket> getTicketsFromEvent(Event event) {
        List<Ticket> allTicketsFromEvent = new ArrayList<>();
        try (Connection c = dbc.getConnection()) {
            String sql = "SELECT * FROM Ticket JOIN Customer ON Ticket.Event_ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, event.getIdProperty().get());
            ps.execute();

            ResultSet rs = ps.getResultSet();
            Ticket ticket = new Ticket();
            Customer customer;
            allTicketsFromEvent.add(ticket);
            while (rs.next()) {
                ticket.setId(rs.getInt(1));
                ticket.setCustomer(customer = new Customer(rs.getString("Email"), rs.getString("FullName")));
                customer.setId(rs.getInt("Customer_ID"));
                ticket.setEvent(event);
                ticket.setPrice(rs.getInt("Price"));
                ticket.setIsPaid(convertBitToBoolean(rs.getByte("IsPaid")));
                ticket.setSeated(convertBitToBoolean(rs.getByte("IsSeated")));
                ticket.setVip(convertBitToBoolean(rs.getByte("IsVIP")));
                ticket.setDrinks(convertBitToBoolean(rs.getInt("IsDrink")));
                ticket.setFood(convertBitToBoolean(rs.getInt("IsFood")));
                ticket.setRow(rs.getString("Row"));
                ticket.setSeat(rs.getString("Seat"));

                allTicketsFromEvent.add(ticket);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allTicketsFromEvent;
    }

    public boolean convertBitToBoolean(int bit) {
        return bit == 1;
    }

}
