package com.birdsanctuary;

@DeveloperInfo(developer = "EcoWing Team", version = "1.1")
public class Duck extends Bird implements Flyable, Swimmable {

    public Duck(String id, String name) {
        super(id, name, "Duck");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " flies short distance.");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " swims in water.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Duck | ID: " + getId() + " | Name: " + getName());
    }
}
