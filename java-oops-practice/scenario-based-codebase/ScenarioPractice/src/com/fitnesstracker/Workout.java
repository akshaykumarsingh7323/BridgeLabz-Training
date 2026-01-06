package com.fitnesstracker;

public abstract class Workout implements ITrackable {

    protected String type;
    protected int duration; 
    protected int caloriesBurned;

    private String internalLog;

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    public abstract void calculateCalories();

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    protected void setInternalLog(String log) {
        this.internalLog = log;
    }

    @Override
    public void startWorkout() {
        System.out.println(type + " workout started.");
    }

    @Override
    public void stopWorkout() {
        System.out.println(type + " workout stopped.");
    }
}
