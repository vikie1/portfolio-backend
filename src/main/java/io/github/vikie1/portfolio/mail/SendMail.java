package io.github.vikie1.portfolio.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import io.github.vikie1.portfolio.contact.Contact;

@Service
@EnableAsync
public class SendMail {
    @Autowired
    JavaMailSender javaMailSender;

    @Async
    public void sendVisitorEmail(Contact contact) {
        String email = contact.getEmail();
        String name = contact.getName();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(email);

            //I'm just going to hardcode everything for now because am very hardworking
            mimeMessageHelper.setSubject("Auto Reply for Contacting Victor Mwangi");
            mimeMessageHelper
                    .setText("Thank you " + name + " for making contact to Victor Mwangi in <a href=\"victormwangi.netlify.app\"></a>. <br>"
                            + "This message is meant to acknowledge reception of the details you sent. <br>"
                            + "I'll review the data and get back to you. <br> <br> HAVE A GREAT DAY.", true);
        } catch (MessagingException e) {
            //Auto-generated catch block
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }

    @Async
    public void sendMyMail(Contact contact) {
        String sender = contact.getEmail();
        String name = contact.getName();
        String subject = contact.getSubject();
        String message = contact.getMessage();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
        try {
            mimeMessageHelper.setTo("mwangivikie@gmail.com");
            mimeMessageHelper.setSubject("New Contact At PortFolio");
            mimeMessageHelper.setText("Received a new email: <br>" + "From: " + sender + "<br>Name: " + name + "<br>Subject: "
                    + subject + "<br>Message: " + message + "<br> <br> GOOD LUCK WITH YOUR NEW CLIENT!", true);
        } catch (MessagingException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }

    public SendMail() {}
}
