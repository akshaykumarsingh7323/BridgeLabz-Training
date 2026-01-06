package com.fitnesstracker;

public class StrengthWorkout extends Workout {

    public StrengthWorkout(int duration) {
        super("Strength", duration);
    }

    @Override
    public void calculateCalories() {
        caloriesBurned = duration * 5;
        setInternalLog("Strength calories calculated");
    }
}
