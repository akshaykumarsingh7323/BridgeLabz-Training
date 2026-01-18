package com.sorting.insertionsort;

public class PackageItem {
    private String id;
    private double weight;

    public PackageItem(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Weight: " + weight;
    }
}

