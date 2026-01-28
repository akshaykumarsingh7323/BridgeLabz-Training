package com.addressbooksystem;

import java.util.ArrayList;
import java.util.Collections;

public class AddressBook {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(contact.getFirstName())
                    && c.getLastName().equalsIgnoreCase(contact.getLastName())) {
                System.out.println("Contact already exists");
                return;
            }
        }
        contacts.add(contact);
        System.out.println("Contact added");
    }

    public void editContact(String firstName, String lastName,
                            String phone, String email) {
        for (Contact c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)
                    && c.getLastName().equalsIgnoreCase(lastName)) {
                c.setPhone(phone);
                c.setEmail(email);
                System.out.println("Contact updated");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void deleteContact(String firstName, String lastName) {
        contacts.removeIf(c ->
                c.getFirstName().equalsIgnoreCase(firstName)
                        && c.getLastName().equalsIgnoreCase(lastName));
        System.out.println("Contact deleted (if existed)");
    }

    public void searchByCityOrState(String keyword) {
        for (Contact c : contacts) {
            if (c.getAddress() != null &&
                    (c.getAddress().getCity().equalsIgnoreCase(keyword)
                            || c.getAddress().getState().equalsIgnoreCase(keyword))) {
                c.display();
            }
        }
    }

    public void displayAll() {
        Collections.sort(contacts);
        for (Contact c : contacts) {
            c.display();
            System.out.println("-----");
        }
    }
}

