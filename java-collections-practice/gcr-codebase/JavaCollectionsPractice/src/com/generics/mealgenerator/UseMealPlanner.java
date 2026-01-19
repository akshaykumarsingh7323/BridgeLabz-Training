package com.generics.mealgenerator;

public class UseMealPlanner {
    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal =
                MealGenerator.generateMeal(new VegetarianMeal());
        vegMeal.showMealDetails();

        Meal<VeganMeal> veganMeal =
                MealGenerator.generateMeal(new VeganMeal());
        veganMeal.showMealDetails();

        Meal<KetoMeal> ketoMeal =
                MealGenerator.generateMeal(new KetoMeal());
        ketoMeal.showMealDetails();

        Meal<HighProteinMeal> proteinMeal =
                MealGenerator.generateMeal(new HighProteinMeal());
        proteinMeal.showMealDetails();
    }
}

