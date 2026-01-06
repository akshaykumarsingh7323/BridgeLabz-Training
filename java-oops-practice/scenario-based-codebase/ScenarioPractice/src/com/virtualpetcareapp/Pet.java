package com.virtualpetcareapp;

import java.util.Random;

public abstract class Pet implements IInteractable {

    protected String name;
    protected String type;
    protected int age;

    private int hunger;   
    private int energy;  
    private String mood;

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;

        Random rand = new Random();
        this.hunger = rand.nextInt(50);
        this.energy = rand.nextInt(50) + 50;
        updateMood();
    }

    public Pet(String name, String type, int age, int hunger, int energy) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.hunger = hunger;
        this.energy = energy;
        updateMood();
    }

    public abstract void makeSound();

    @Override
    public void feed() {
        hunger -= 20;
        if (hunger < 0) hunger = 0;
        updateMood();
        System.out.println(name + " has been fed.");
    }

    @Override
    public void play() {
        energy -= 20;
        hunger += 15;
        updateMood();
        System.out.println(name + " played happily!");
    }

    @Override
    public void sleep() {
        energy += 30;
        if (energy > 100) energy = 100;
        updateMood();
        System.out.println(name + " is sleeping.");
    }

    private void updateMood() {
        if (energy > 70 && hunger < 30)
            mood = "Happy 😊";
        else if (hunger > 70)
            mood = "Hungry 😟";
        else
            mood = "Normal 🙂";
    }

    public void showStatus() {
        System.out.println("Pet: " + name + " (" + type + ")");
        System.out.println("Age: " + age);
        System.out.println("Hunger: " + hunger);
        System.out.println("Energy: " + energy);
        System.out.println("Mood: " + mood);
        System.out.println("---------------------");
    }
}
