package io.github.vikie1.portfolio.contact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ContactService
 */

@Service
public class ContactService {

    @Autowired
    ContactRepo contactRepo;

    public List<String> addContact(Contact contact) {
        contactRepo.save(contact);
        List<String> reply = new ArrayList<>();
        reply.add("success");
        return reply;
    }

    public void clear(){
        contactRepo.deleteAll();
    }
}