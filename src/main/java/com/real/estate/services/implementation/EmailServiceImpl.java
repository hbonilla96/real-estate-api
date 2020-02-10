package com.real.estate.services.implementation;

import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.smtp.*;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    public void sendEmail(String recipient, String subject, String email) throws javax.mail.MessagingException {
        Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("vbonillab12@gmail.com"));;
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(recipient, false));
        msg.setSubject(subject);
        msg.setText(email);
        msg.setHeader("X-Mailer", "Tov Are's program");
        msg.setSentDate(new Date());
        SMTPTransport t =
                (SMTPTransport)session.getTransport("smtps");
        t.connect("smtp.gmail.com", "hbonillab@ucenfotec.ac.cr", "203075mail");
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
    }
}
