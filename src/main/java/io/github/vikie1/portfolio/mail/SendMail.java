package io.github.vikie1.portfolio.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import io.github.vikie1.portfolio.contact.Contact;

@Component
@EnableAsync
public class SendMail {
    @Autowired
    JavaMailSender javaMailSender;

    @Async
    public void sendVisitorEmail(Contact contact) {
        String email = contact.getEmail();
        String name = contact.getName();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Auto Reply for Contacting Victor Mwangi");
        simpleMailMessage
                .setText("Thank you " + name + " for making contact to Victor Mwangi in victormwangi.netlify.app. \n"
                        + "This message is meant to acknowledge reception of the details you sent.\n"
                        + "I'll review the data and get back to you");
    }

    @Async
    public void sendMyMail(Contact contact) {
        String sender = contact.getEmail();
        String name = contact.getName();
        String subject = contact.getSubject();
        String message = contact.getMessage();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("mwangivikie@gmail.com");
        simpleMailMessage.setSubject("New Contact At PortFolio");
        simpleMailMessage.setText("Received a new email: <br>" + "From: " + sender + "Name: " + name + "Subject: "
                + subject + "Message: " + message + "<br> <br> GOOD LUCK WITH YOUR NEW CLIENT!");
    }
}
