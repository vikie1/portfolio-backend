package io.github.vikie1.portfolio.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ContactControler {
    
    @Autowired
    ContactService contactService;

    @PostMapping(value="/api/contact")
    public List<String> postMethodName(@RequestBody Contact entity) {
        //TODO: process POST request for the contact page
        List<String> reply = contactService.addContact(entity);
        return reply;
    }
    
    @DeleteMapping(value = "/api/contact")
    public void deleteContacts() {
        contactService.clear();
    }
}
