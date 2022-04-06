package bll.util;


import be.Ticket;
import javafx.scene.shape.Path;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

public class pdfConverter {
    private static String FILEPATH = "src/gui/utility/temp/ticketList.pdf";
    //Setup for DPF page
    private static PDFont font = PDType1Font.HELVETICA;
    private static PDFont fontBold = PDType1Font.HELVETICA_BOLD;
    private static PDPage page = new PDPage();
    private static int startX = 20;

    public static void printToPdf(List<Ticket> ticketList) {
        if (ticketList.isEmpty())
            return;

        try (PDDocument doc = new PDDocument()) {
            doc.addPage(page);
            PDPageContentStream content = new PDPageContentStream(doc, page);

            setTitleAndSubtitles(content, ticketList.get(0).getEvent().getTitleProperty().get());

            int lines = 1;
            float pageHeight = page.getMediaBox().getHeight()-60;

            for (Ticket ticket : ticketList) {
                String VIPStatus = "No";
                startX = 20;

                if (ticket.getVipProperty().get())
                    VIPStatus = "Yes";


                content.setFont(font, 8);

                String [] ticketInformation = { ticket.getCustomer().getNameProperty().get(), ticket.getCustomer().getEmailProperty().get(),
                                                ticket.getCustomer().getTelephoneNumberProperty().get(), ticket.getIdProperty().get(), VIPStatus};
                for (int i = 0; i < 5; i++) {
                    content.beginText();
                    content.newLineAtOffset(startX, pageHeight - 30 * lines);

                    if (i == 1 || i == 0)
                        startX = startX + (150);
                    else if (i == 2)
                        startX = startX + (100);
                    else
                        startX = startX + (85);

                    content.showText(ticketInformation[i]);
                    content.endText();
                }
                ++lines;
                if (lines % 30 == 0) {
                    page = new PDPage();
                    doc.addPage(page);
                    setTitleAndSubtitles(content, ticket.getEvent().getTitleProperty().get());
                    content.close();
                    content = new PDPageContentStream(doc, page);
                    content.setFont(font, 12);
                }
            }
            content.close();
            doc.save(FILEPATH);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setTitleAndSubtitles(PDPageContentStream content, String title) throws IOException {
        // Set up title
        content.setFont(fontBold, 20);
        content.beginText();
        content.newLineAtOffset(page.getMediaBox().getWidth()/2 -50, page.getMediaBox().getHeight()-30);
        content.showText(title);
        content.endText();


        //Set up titles on page 1
        String [] subtitles = {"Navn", "Email", "Telefon", "Ticket ID", "VIP"};

        content.setFont(fontBold, 12);
        for (int i = 0; i < 5; i++) {
            content.beginText();
            content.newLineAtOffset(startX, page.getMediaBox().getHeight() - 60);

            if (i == 1 || i == 0)
                startX = startX + (150);
            else if (i == 2)
                startX = startX + (100);
            else
                startX = startX + (85);

            content.showText(subtitles[i]);
            content.endText();
        }
    }


}