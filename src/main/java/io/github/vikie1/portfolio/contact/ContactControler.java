package io.github.vikie1.portfolio.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.vikie1.portfolio.mail.SendMailService;


@RestController
//@CrossOrigin(origins = "https://victormwangi.netlify.app")
//@CrossOrigin(origins = "http://localhost:3000/")
public class ContactControler {
    
    @Autowired
    ContactService contactService;

    @Autowired
    SendMailService sendMailService;

    @PostMapping(value="/api/contact")
    public List<String> postMethodName(@RequestBody Contact entity) {
        sendMailService.send(entity);
        return contactService.addContact(entity);
    }
    
    @DeleteMapping(value = "/api/contact")
    public void deleteContacts() {
        contactService.clear();
    }
}
