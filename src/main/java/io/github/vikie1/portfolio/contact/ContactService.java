package io.github.vikie1.portfolio.contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepo contactRepo;

    public List<String> addContact(Contact contact) {
        contactRepo.save(contact);
        return new ArrayList<>(Collections.singleton("success"));
    }

    public void deleteContact(int id){ contactRepo.deleteById(id); }

    public void clear(){
        contactRepo.deleteAll();
    }
}