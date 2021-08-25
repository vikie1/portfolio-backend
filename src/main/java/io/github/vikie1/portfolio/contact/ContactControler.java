package io.github.vikie1.portfolio.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.github.vikie1.portfolio.mail.SendMailService;


@RestController
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

    @DeleteMapping(value = "/api/contact/{id}")
    public void deleteContact(@PathVariable int id){ contactService.deleteContact(id); }
}
