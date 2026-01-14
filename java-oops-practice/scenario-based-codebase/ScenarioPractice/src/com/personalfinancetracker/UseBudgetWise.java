package com.personalfinancetracker;

import java.time.LocalDate;
import java.util.HashMap;

public class UseBudgetWise {
    public static void main(String[] args) {

        HashMap<String, Double> categories = new HashMap<>();
        categories.put("Food", 5000.0);
        categories.put("Travel", 3000.0);

        Budget budget = new MonthlyBudget(20000, 15000, categories);

        budget.addTransaction(new Transaction(
                4000, "EXPENSE", LocalDate.now(), "Food"));

        budget.addTransaction(new Transaction(
                3500, "EXPENSE", LocalDate.now(), "Travel"));

        budget.generateReport();
        budget.detectOverspend();
    }
}

