package com.virtualpetcareapp;

public class UsePetPal {

    public static void main(String[] args) {

        Pet pet1 = new Dog("Buddy", 3);
        Pet pet2 = new Cat("Luna", 2);
        Pet pet3 = new Bird("Sky", 1);

        pet1.makeSound();
        pet1.feed();
        pet1.play();
        pet1.showStatus();

        pet2.makeSound();
        pet2.play();
        pet2.sleep();
        pet2.showStatus();

        pet3.makeSound();
        pet3.feed();
        pet3.sleep();
        pet3.showStatus();
    }
}
