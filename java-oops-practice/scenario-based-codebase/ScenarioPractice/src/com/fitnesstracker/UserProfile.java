package com.fitnesstracker;

public class UserProfile {

    private String name;
    private int age;
    private double weight; 
    private int dailyCalorieTarget;

    public UserProfile(String name, int age, double weight) {
        this(name, age, weight, 2000);
    }

    public UserProfile(String name, int age, double weight, int target) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.dailyCalorieTarget = target;
    }

    public double getWeight() {
        return weight;
    }

    public int calculateProgress(int caloriesBurned) {
        return dailyCalorieTarget - caloriesBurned;
    }

    public void displayProfile() {
        System.out.println("User: " + name);
        System.out.println("Daily Target: " + dailyCalorieTarget);
    }
}
