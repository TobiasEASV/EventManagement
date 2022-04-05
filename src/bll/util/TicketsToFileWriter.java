package bll.util;


import be.Ticket;
import gui.controller.EventCoordinatorDashboardController;
import gui.model.PrintModel;

import javax.print.PrintService;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketsToFileWriter {

    public static void printToPdf(List<Ticket> ticketList, PrintService ps) {
        var fileName = System.getProperty("user.home") + "/Desktop/Tickets Overview.txt";

        try (var fw = new FileWriter(fileName, StandardCharsets.UTF_8)) {
            String formatStr = "%-25s %-25s %-19s %-13s %-1s%n";
            fw.write(String.format(formatStr,"Navn", "Email","Telefon", "ID", "VIP"));
            fw.write("\n");

            for (Ticket t: ticketList) {
                String vipStatus = "No";
                if (t.getVipProperty().get())
                    vipStatus = "Yes";
                fw.write(String.format(formatStr, t.getCustomer().getNameProperty().get(), t.getCustomer().getEmailProperty().get(),
                t.getCustomer().getTelephoneNumberProperty().get(),t.getIdProperty().get(), vipStatus));
            }
            /**PrintModel pm = new PrintModel();
            TimeUnit.SECONDS.sleep(2);
            pm.print(ps, System.getProperty("user.home") + "/Desktop/Tickets Overview.txt");*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}