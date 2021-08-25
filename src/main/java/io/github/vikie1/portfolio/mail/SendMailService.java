package io.github.vikie1.portfolio.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.vikie1.portfolio.contact.Contact;

@Service
public class SendMailService {
    @Autowired
    SendMail sendMail;

    public void send(Contact contact) {
        try {
            sendMail.sendVisitorEmail(contact);
            sendMail.sendMyMail(contact);
        } catch (Exception e) {
            //just do nothing, but you have to stay here to prevent runtime crashing
        }
    }
}
