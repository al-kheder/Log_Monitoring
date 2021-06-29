package Managers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MailManager {
    private static final Logger LOG = LoggerFactory.getLogger(MailManager.class);

    public void sendMail(String recipient, HashMap<String, List<String>> matches) {


        Properties props = ConfigurationManager.getInstance().getMailProperties();

        final String myAccount = props.getProperty("mail.smtp.user");
        final String password = props.getProperty("mail.smtp.password");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }
        });
        //TO DO
        Message message = prepareMessage(session, myAccount, recipient, matches);
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            LOG.error("Error sending mail. Exiting.", e);
            System.exit(1);
        }

        LOG.info("Mail was sent successfuly");
    }

    public static Message prepareMessage(Session session, String myAccount, String recipients, HashMap<String, List<String>> matches) {

        StringBuilder messageText = new StringBuilder();

        //Formate the Reciever
        String[] recipent = recipients.split(",");

        List<String> allRecipient = new ArrayList<String>();
        allRecipient = Arrays.asList(recipent);
        messageText.append("Hallo ");
        for (String reci : allRecipient) {
            int index = reci.indexOf("@");
            reci = reci.substring(0, index);
            messageText.append(reci + ",");
        }
        messageText.append("\n");

        // Print the Message
        for (Map.Entry<String, List<String>> entry : matches.entrySet()) {
            for (String match : entry.getValue()) {
                messageText
                        .append("Match for ")
                        .append(entry.getKey())
                        .append(",\n matched line: ")
                        .append(match)
                        .append("\n");
            }
        }

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            message.setSubject("Test E_Mail for Log File ");
            message.setText(messageText.toString());
            return message;
        } catch (Exception ex) {
            LOG.error("Error preparing mail to be sent.", ex);
            System.exit(1);
        }
        return null;
    }

}



