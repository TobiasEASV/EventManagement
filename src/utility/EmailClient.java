package utility;
import be.Email;
import bll.interfaces.IEmailManager;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.*;

public class EmailClient {

    private IEmailManager iEmailManager;

    public EmailClient(IEmailManager iEmailManager) throws IOException {
        this.iEmailManager = iEmailManager;
    }

    public Boolean sendEmail(String toEmail, String subject, String text, String attachmentFileURL) throws IOException {

        Properties emailSetup = new Properties();
        emailSetup.put("mail.smtp.host", "smtp.outlook.com");
        emailSetup.put("mail.smtp.port", "587");
        emailSetup.put("mail.smtp.auth", "true");
        emailSetup.put("mail.smtp.starttls.enable", "true"); //TLS;

        Email emailCredentials = iEmailManager.getCredentials();

        Session session = Session.getInstance(emailSetup, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailCredentials.getEmailNameProperty().get(), emailCredentials.getPasswordProperty().get());}
                });
            try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailCredentials.getEmailNameProperty().get()));
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
}
