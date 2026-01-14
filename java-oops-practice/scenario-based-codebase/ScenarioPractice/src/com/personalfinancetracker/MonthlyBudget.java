package com.personalfinancetracker;

import java.util.HashMap;

class MonthlyBudget extends Budget {

    public MonthlyBudget(double income, double limit, HashMap<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    @Override
    public void generateReport() {
        System.out.println("📅 Monthly Budget Report");
        System.out.println("Income: ₹" + income);
        System.out.println("Expenses: ₹" + getTotalExpenses());
        System.out.println("Savings: ₹" + getNetSavings());
    }

    @Override
    public void detectOverspend() {
        HashMap<String, Double> spent = getCategoryExpenses();
        for (String cat : spent.keySet()) {
            if (spent.get(cat) > categoryLimits.getOrDefault(cat, Double.MAX_VALUE)) {
                System.out.println("⚠ Overspend in category: " + cat);
            }
        }
    }
}

