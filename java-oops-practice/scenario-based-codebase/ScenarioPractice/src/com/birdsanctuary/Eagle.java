package com.birdsanctuary;

@DeveloperInfo(developer = "EcoWing Team", version = "1.0")
public class Eagle extends Bird implements Flyable {

    public Eagle(String id, String name) {
        super(id, name, "Eagle");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying high.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Eagle | ID: " + getId() + " | Name: " + getName());
    }
}

