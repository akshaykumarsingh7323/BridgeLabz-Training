package com.fitnesstracker;

public class CardioWorkout extends Workout {

    public CardioWorkout(int duration) {
        super("Cardio", duration);
    }

    @Override
    public void calculateCalories() {
        caloriesBurned = duration * 8;
        setInternalLog("Cardio calories calculated");
    }
}
