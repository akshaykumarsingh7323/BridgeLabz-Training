package com.travelitineraryplanner;

public class Transport {

    private String mode;
    private double cost;

    public Transport(String mode, double cost) {
        this.mode = mode;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
