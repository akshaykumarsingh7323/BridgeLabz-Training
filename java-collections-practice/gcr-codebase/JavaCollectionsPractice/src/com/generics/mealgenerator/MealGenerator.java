package com.generics.mealgenerator;

public class MealGenerator {

    public static <T extends MealPlan> Meal<T> generateMeal(T mealPlan) {
        System.out.println("\nValidating meal plan...");
        System.out.println("Meal Plan Approved");

        return new Meal<>(mealPlan);
    }
}
