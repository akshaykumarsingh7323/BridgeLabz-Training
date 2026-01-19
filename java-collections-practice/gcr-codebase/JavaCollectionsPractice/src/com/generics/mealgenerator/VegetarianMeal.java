package com.generics.mealgenerator;

public class VegetarianMeal implements MealPlan {

    public String getMealType() {
        return "Vegetarian Meal";
    }

    public int getCalories() {
        return 500;
    }
}
