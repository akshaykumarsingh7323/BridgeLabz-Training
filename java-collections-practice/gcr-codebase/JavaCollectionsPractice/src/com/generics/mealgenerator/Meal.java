package com.generics.mealgenerator;

public class Meal<T extends MealPlan> {

    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void showMealDetails() {
        System.out.println("Meal Type   : " + mealPlan.getMealType());
        System.out.println("Calories    : " + mealPlan.getCalories());
    }
}
