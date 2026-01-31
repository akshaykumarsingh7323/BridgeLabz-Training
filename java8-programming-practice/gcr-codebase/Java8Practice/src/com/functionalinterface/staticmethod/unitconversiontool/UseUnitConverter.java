package com.functionalinterface.staticmethod.unitconversiontool;

public class UseUnitConverter {

    public static void main(String[] args) {

        double distanceKm = 50;
        double weightKg = 20;

        System.out.println(distanceKm + " km = " + UnitConverter.kmToMiles(distanceKm) + " miles");

        System.out.println(weightKg + " kg = " + UnitConverter.kgToLbs(weightKg) + " lbs");
    }
}
