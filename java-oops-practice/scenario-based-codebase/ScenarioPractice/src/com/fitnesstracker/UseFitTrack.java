package com.fitnesstracker;

public class UseFitTrack {

    public static void main(String[] args) {

        UserProfile user = new UserProfile("Akshay", 24, 72.5, 2500);
        user.displayProfile();

        Workout workout1 = new CardioWorkout(30);
        Workout workout2 = new StrengthWorkout(40);

        workout1.startWorkout();
        workout1.calculateCalories();
        workout1.stopWorkout();

        workout2.startWorkout();
        workout2.calculateCalories();
        workout2.stopWorkout();

        int totalCalories = workout1.getCaloriesBurned() + workout2.getCaloriesBurned();

        System.out.println("Calories Burned Today: " + totalCalories);

        int remaining = user.calculateProgress(totalCalories);

        System.out.println("Remaining Calories to Target: " + remaining);
    }
}

