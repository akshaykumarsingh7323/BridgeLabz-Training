package com.contactapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.contactapp.dto.ContactDTO;
import com.contactapp.entity.Contact;
import com.contactapp.exception.ContactNotFoundException;
import com.contactapp.exception.DuplicateContactException;
import com.contactapp.repository.ContactRepository;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    ContactRepository contactRepository;

    @InjectMocks
    ContactService contactService;

    @Test
    void addContact() {

        ContactDTO dto = new ContactDTO(
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        Contact contact = new Contact(
                1,
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        when(contactRepository.existsByEmail("akshay@gmail.com"))
                .thenReturn(false);

        when(contactRepository.existsByPhone("9876543210"))
                .thenReturn(false);

        when(contactRepository.save(any(Contact.class)))
                .thenReturn(contact);

        Contact result = contactService.addContact(dto);

        assertEquals("Akshay", result.getName());
        assertEquals("9876543210", result.getPhone());
        assertEquals("akshay@gmail.com", result.getEmail());
    }

    @Test
    void addContactWithDuplicateEmail() {

        ContactDTO dto = new ContactDTO(
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        when(contactRepository.existsByEmail("akshay@gmail.com"))
                .thenReturn(true);

        assertThrows(
                DuplicateContactException.class,
                () -> contactService.addContact(dto)
        );
    }

    @Test
    void addContactWithDuplicatePhone() {

        ContactDTO dto = new ContactDTO(
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        when(contactRepository.existsByEmail("akshay@gmail.com"))
                .thenReturn(false);

        when(contactRepository.existsByPhone("9876543210"))
                .thenReturn(true);

        assertThrows(
                DuplicateContactException.class,
                () -> contactService.addContact(dto)
        );
    }

    @Test
    void getAllContacts() {

        Contact c1 = new Contact(
                1,
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        Contact c2 = new Contact(
                2,
                "Rahul",
                "8765432109",
                "rahul@gmail.com"
        );

        when(contactRepository.findAll())
                .thenReturn(Arrays.asList(c1, c2));

        List<Contact> result = contactService.getAllContacts();

        assertEquals(2, result.size());
    }

    @Test
    void getContactById() {

        Contact contact = new Contact(
                1,
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        when(contactRepository.findById(1))
                .thenReturn(Optional.of(contact));

        Contact result = contactService.getContactById(1);

        assertEquals(1, result.getId());
        assertEquals("Akshay", result.getName());
    }

    @Test
    void getContactByIdWhenNotFound() {

        when(contactRepository.findById(10))
                .thenReturn(Optional.empty());

        assertThrows(
                ContactNotFoundException.class,
                () -> contactService.getContactById(10)
        );
    }

    @Test
    void updateContact() {

        Contact contact = new Contact(
                1,
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        ContactDTO dto = new ContactDTO(
                "Akshay Kumar",
                "8765432109",
                "akshaykumar@gmail.com"
        );

        when(contactRepository.findById(1))
                .thenReturn(Optional.of(contact));

        when(contactRepository.existsByEmailAndIdNot(
                dto.getEmail(), 1))
                .thenReturn(false);

        when(contactRepository.existsByPhoneAndIdNot(
                dto.getPhone(), 1))
                .thenReturn(false);

        when(contactRepository.save(contact))
                .thenReturn(contact);

        Contact result = contactService.updateContact(1, dto);

        assertEquals("Akshay Kumar", result.getName());
        assertEquals("8765432109", result.getPhone());
        assertEquals("akshaykumar@gmail.com", result.getEmail());
    }

    @Test
    void updateContactWhenIdNotFound() {

        ContactDTO dto = new ContactDTO(
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        when(contactRepository.findById(10))
                .thenReturn(Optional.empty());

        assertThrows(
                ContactNotFoundException.class,
                () -> contactService.updateContact(10, dto)
        );
    }

    @Test
    void updateContactWithDuplicateEmail() {

        Contact contact = new Contact(
                1,
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        ContactDTO dto = new ContactDTO(
                "Akshay",
                "8765432109",
                "rahul@gmail.com"
        );

        when(contactRepository.findById(1))
                .thenReturn(Optional.of(contact));

        when(contactRepository.existsByEmailAndIdNot(
                dto.getEmail(), 1))
                .thenReturn(true);

        assertThrows(
                DuplicateContactException.class,
                () -> contactService.updateContact(1, dto)
        );
    }

    @Test
    void updateContactWithDuplicatePhone() {

        Contact contact = new Contact(
                1,
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        ContactDTO dto = new ContactDTO(
                "Akshay",
                "8765432109",
                "new@gmail.com"
        );

        when(contactRepository.findById(1))
                .thenReturn(Optional.of(contact));

        when(contactRepository.existsByEmailAndIdNot(
                dto.getEmail(), 1))
                .thenReturn(false);

        when(contactRepository.existsByPhoneAndIdNot(
                dto.getPhone(), 1))
                .thenReturn(true);

        assertThrows(
                DuplicateContactException.class,
                () -> contactService.updateContact(1, dto)
        );
    }

    @Test
    void deleteContact() {

        Contact contact = new Contact(
                1,
                "Akshay",
                "9876543210",
                "akshay@gmail.com"
        );

        when(contactRepository.findById(1))
                .thenReturn(Optional.of(contact));

        contactService.deleteContact(1);

        verify(contactRepository).delete(contact);
    }

    @Test
    void deleteContactWhenNotFound() {

        when(contactRepository.findById(10))
                .thenReturn(Optional.empty());

        assertThrows(
                ContactNotFoundException.class,
                () -> contactService.deleteContact(10)
        );

        verify(contactRepository, never())
                .delete(any(Contact.class));
    }
}