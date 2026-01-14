package com.personalfinancetracker;

import java.util.HashMap;

class AnnualBudget extends Budget {

    public AnnualBudget(double income, double limit, HashMap<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    @Override
    public void generateReport() {
        System.out.println("📆 Annual Budget Summary");
        System.out.println("Yearly Income: ₹" + income);
        System.out.println("Yearly Expenses: ₹" + getTotalExpenses());
        System.out.println("Yearly Savings: ₹" + getNetSavings());
    }

    @Override
    public void detectOverspend() {
        if (getTotalExpenses() > limit) {
            System.out.println("⚠ Annual budget limit exceeded!");
        }
    }
}


