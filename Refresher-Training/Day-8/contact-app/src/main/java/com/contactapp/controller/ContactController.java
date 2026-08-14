package com.contactapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactapp.dto.ContactDTO;
import com.contactapp.entity.Contact;
import com.contactapp.service.ContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // CREATE CONTACT
    @PostMapping
    public ResponseEntity<Contact> addContact(
            @Valid @RequestBody ContactDTO dto) {

        Contact contact = contactService.addContact(dto);

        return new ResponseEntity<>(
                contact,
                HttpStatus.CREATED
        );
    }

    // GET ALL CONTACTS
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {

        return ResponseEntity.ok(
                contactService.getAllContacts()
        );
    }

    // GET CONTACT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(
            @PathVariable int id) {

        return ResponseEntity.ok(
                contactService.getContactById(id)
        );
    }

    // UPDATE CONTACT
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(
            @PathVariable int id,
            @Valid @RequestBody ContactDTO dto) {

        return ResponseEntity.ok(
                contactService.updateContact(id, dto)
        );
    }

    // DELETE CONTACT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(
            @PathVariable int id) {

        contactService.deleteContact(id);

        return ResponseEntity.ok(
                "Contact deleted successfully"
        );
    }
}