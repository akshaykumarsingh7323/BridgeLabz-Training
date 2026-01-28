package com.birdsanctuary;

@DeveloperInfo(developer = "Wildlife Team", version = "1.0")
public class Kiwi extends Bird {

    public Kiwi(String id, String name) {
        super(id, name, "Kiwi");
    }

    @Override
    public void displayInfo() {
        System.out.println("Kiwi | ID: " + getId() + " | Name: " + getName());
    }
}

