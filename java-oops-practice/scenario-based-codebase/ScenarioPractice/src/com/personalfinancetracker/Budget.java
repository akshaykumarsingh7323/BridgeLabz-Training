package com.personalfinancetracker;

import java.util.ArrayList;
import java.util.HashMap;

abstract class Budget implements IAnalyzable {

    protected double income;
    protected double limit;

    protected HashMap<String, Double> categoryLimits;

    private ArrayList<Transaction> transactions;

    public Budget(double income, double limit, HashMap<String, Double> categoryLimits) {
        this.income = income;
        this.limit = limit;
        this.categoryLimits = categoryLimits;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    protected double getTotalExpenses() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("EXPENSE")) {
                total += t.getAmount(); 
            }
        }
        return total;
    }

    protected HashMap<String, Double> getCategoryExpenses() {
        HashMap<String, Double> map = new HashMap<>();
        for (Transaction t : transactions) {
            if (t.getType().equals("EXPENSE")) {
                map.put(
                    t.getCategory(),
                    map.getOrDefault(t.getCategory(), 0.0) + t.getAmount()
                );
            }
        }
        return map;
    }

    protected double getNetSavings() {
        return income - getTotalExpenses();
    }
}
