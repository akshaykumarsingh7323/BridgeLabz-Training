package com.addressbooksystem;

public class Contact implements Comparable<Contact> {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;

    public Contact(String firstName, String lastName, String phone, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public Address getAddress() { return address; }

    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(Address address) { this.address = address; }

    @Override
    public int compareTo(Contact c) {
        return (this.firstName + this.lastName)
                .compareToIgnoreCase(c.firstName + c.lastName);
    }

    public void display() {
        System.out.println(firstName + " " + lastName +
                " | Phone: " + phone +
                " | Email: " + email);

        if (address != null) {
            System.out.println("  Address: " + address.getCity() + ", " + address.getState() + " - " + address.getZip());
        }
    }
}
