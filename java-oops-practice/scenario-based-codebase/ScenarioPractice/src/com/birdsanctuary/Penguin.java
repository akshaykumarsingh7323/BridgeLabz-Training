package com.birdsanctuary;

@DeveloperInfo(developer = "Research Team", version = "2.0")
public class Penguin extends Bird implements Swimmable {

    public Penguin(String id, String name) {
        super(id, name, "Penguin");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " swims underwater.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Penguin | ID: " + getId() + " | Name: " + getName());
    }
}
