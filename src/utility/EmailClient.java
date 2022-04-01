package utility;

import bll.EmailManager;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class EmailClient {
    
    private static final String PROP_FILE = ".data/email.settings";

    private EmailManager emailManager;

    public EmailClient() throws IOException {
        //emailManager = new EmailManager();
    }

    public Boolean sendEmail(String toEmail, String subject, String text, String attachmentFileURL) throws IOException {



        Properties emailCredentials = new Properties();
        emailCredentials.load(new FileInputStream(PROP_FILE));
        //HashMap<String,String> credentials = emailManager.getCredentials();


        //final String email = credentials.get("Email");
        //final String password = credentials.get("Password");

        final String email = emailCredentials.getProperty("Email");
        final String password = emailCredentials.getProperty("Password");

        System.out.println("Eamil= " + email);
        System.out.println("Password = " + password);

        Properties emailSetup = new Properties();

            emailSetup.put("mail.smtp.host", "smtp.outlook.com");
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

                // Add a Ticket to the mail
                Multipart multipart = new MimeMultipart();
                MimeBodyPart attachmentPart = new MimeBodyPart();
                MimeBodyPart textPart = new MimeBodyPart();

                try {
                    attachmentPart.attachFile(attachmentFileURL);
                    textPart.setText(text);
                    multipart.addBodyPart(textPart);
                    multipart.addBodyPart(attachmentPart);
                } catch (IOException IOe) {
                    IOe.printStackTrace();
                }
                message.setContent(multipart);

            Transport.send(message);

        } catch (MessagingException MessagEX) {
                MessagEX.printStackTrace();
            return false;
        }
            return true;
    }
/**
    public static void main(String[] args) throws IOException {
        EmailClient emailClient = new EmailClient();
        String sendTo = "tobi9782@easv365.dk";
        if(emailClient.sendEmail(sendTo, "Your ticket", "Congratulations on your ticket, to Esbjerg musik hus", "src/gui/images/Icons/ticket_2_icon.png")){
            System.out.println("yesss");
        }
    }
 **/
}
