package com.example.toyforhrteamproject.security.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailUtil {
    public static void sendMail(String receiver, String randomizedRegistrationToken) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.ssl.enable", "true");

        String myAccount = "yby233@gmail.com";
        String password = "Ybby2012";

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }
        });

        Message message = prepareMessage(session, myAccount, receiver, randomizedRegistrationToken);
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static Message prepareMessage(Session session, String myAccount, String receiver,
                                          String randomizedRegistrationToken) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject("Registration token from HR");
            String htmlCode = "<h1> Registration token </h1> <br/> <h2>" + randomizedRegistrationToken + "</h2>";
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
