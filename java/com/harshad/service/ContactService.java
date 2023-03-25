package com.harshad.service;

import org.springframework.stereotype.Service;

import com.harshad.model.Contact;
import com.harshad.repository.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact save(Contact contact) {
        // add any validation or business logic here
        return contactRepository.save(contact);
    }

    // add any other methods here
}

