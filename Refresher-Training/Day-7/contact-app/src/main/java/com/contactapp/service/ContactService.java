package com.contactapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contactapp.dto.ContactDTO;
import com.contactapp.entity.Contact;
import com.contactapp.exception.ContactNotFoundException;
import com.contactapp.exception.DuplicateContactException;
import com.contactapp.repository.ContactRepository;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // CREATE
    public Contact addContact(ContactDTO dto) {

        // Check duplicate email
        if (contactRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateContactException("Email already exists: " + dto.getEmail());
        }

        // Check duplicate phone
        if (contactRepository.existsByPhone(dto.getPhone())) {
            throw new DuplicateContactException("Phone number already exists: " + dto.getPhone());
        }

        Contact contact = new Contact();

        contact.setName(dto.getName());
        contact.setPhone(dto.getPhone());
        contact.setEmail(dto.getEmail());

        return contactRepository.save(contact);
    }

    // GET ALL
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // GET BY ID
    public Contact getContactById(int id) {

        return contactRepository.findById(id)
                .orElseThrow(() ->
                    new ContactNotFoundException(
                        "Contact with id " + id + " not found"
                    )
                );
    }

    // UPDATE
    public Contact updateContact(int id, ContactDTO dto) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                    new ContactNotFoundException(
                        "Contact with id " + id + " not found"
                    )
                );

        // Check if email belongs to another contact
        if (contactRepository.existsByEmailAndIdNot(dto.getEmail(), id)) {
            throw new DuplicateContactException("Email already exists: " + dto.getEmail());
        }

        // Check if phone belongs to another contact
        if (contactRepository.existsByPhoneAndIdNot(dto.getPhone(), id)) {
            throw new DuplicateContactException("Phone number already exists: " + dto.getPhone());
        }

        contact.setName(dto.getName());
        contact.setPhone(dto.getPhone());
        contact.setEmail(dto.getEmail());

        return contactRepository.save(contact);
    }

    // DELETE
    public void deleteContact(int id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                    new ContactNotFoundException(
                        "Contact with id " + id + " not found"
                    )
                );

        contactRepository.delete(contact);
    }
}