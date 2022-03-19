package utility;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EmailClient {
    // Email name:event.ticket.easv@gamil.com
    // Email Code:AdminEASV2022
    private static final String PROP_FILE = ".data/email.settings";
    //private final String username = "tobi9782@easv365.dk";
    //private final String password = "EasvPoker123!!!";




    private Boolean sendEmail(String toEmail, String subject, String text) throws IOException {

        Properties emailCredentials = new Properties();
        emailCredentials.load(new FileInputStream(PROP_FILE));

        final String email = emailCredentials.getProperty("Email");
        final String password = emailCredentials.getProperty("Password");

        Properties emailSetup = new Properties();

            emailSetup.put("mail.smtp.host", "smtp.office365.com");
            emailSetup.put("mail.smtp.port", "587");
            emailSetup.put("mail.smtp.auth", "true");
            emailSetup.put("mail.smtp.starttls.enable", "true"); //TLS;

        Session session = Session.getInstance(emailSetup, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });

            try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );


            message.setSubject(subject);
            message.setText(text);



                // Add a Ticket to the mail
                Multipart multipart = new MimeMultipart();
                MimeBodyPart attachmentPart = new MimeBodyPart();
                try {
                    attachmentPart.attachFile("src/gui/images/Icons/ticket_1_icon.png");
                    multipart.addBodyPart(attachmentPart);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                message.setContent(multipart);
                
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
            return true;
    }

    public static void main(String[] args) throws IOException {
        EmailClient emailClient = new EmailClient();
        String sendTo = "tobi9782@easv365.dk";
        if(emailClient.sendEmail(sendTo, "Your ticket", "Congratulations on your ticket, to Esbjerg musik hus")){
            System.out.println("Wooooooo");
        }
    }
}
