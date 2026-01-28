package com.birdsanctuary;

import java.util.ArrayList;
import java.util.List;

public class BirdSanctuary {

    private List<Bird> birds = new ArrayList<>();

    public void addBird(Bird bird) {
        birds.add(bird);
    }

    public void displayAllBirds() {
    	if(birds.size() == 0) {
    		System.out.println("No birds added!");
    		return;
    	}
    	
        for (Bird b : birds) {
            b.displayInfo();
            b.eat();

            if (b instanceof Flyable) ((Flyable) b).fly();
            if (b instanceof Swimmable) ((Swimmable) b).swim();

            System.out.println("-----");
        }
    }

    public void displayFlyingBirds() {
        for (Bird b : birds) {
            if (b instanceof Flyable) {
                b.displayInfo();
                ((Flyable) b).fly();
            }
        }
    }

    public void displaySwimmingBirds() {
        for (Bird b : birds) {
            if (b instanceof Swimmable) {
                b.displayInfo();
                ((Swimmable) b).swim();
            }
        }
    }

    public void displayFlyingAndSwimmingBirds() {
        for (Bird b : birds) {
            if (b instanceof Flyable && b instanceof Swimmable) {
                b.displayInfo();
                ((Flyable) b).fly();
                ((Swimmable) b).swim();
            }
        }
    }

    public void removeBirdById(String id) {
        birds.removeIf(b -> b.getId().equals(id));
    }

    public void sanctuaryReport() {
        int fly = 0, swim = 0, both = 0, neither = 0;

        for (Bird b : birds) {
            boolean f = b instanceof Flyable;
            boolean s = b instanceof Swimmable;

            if (f && s) both++;
            else if (f) fly++;
            else if (s) swim++;
            else neither++;
        }

        System.out.println("\n------ Sanctuary Report ------");
        System.out.println("Flyable: " + fly);
        System.out.println("Swimmable: " + swim);
        System.out.println("Both: " + both);
        System.out.println("Neither: " + neither);
    }
}
