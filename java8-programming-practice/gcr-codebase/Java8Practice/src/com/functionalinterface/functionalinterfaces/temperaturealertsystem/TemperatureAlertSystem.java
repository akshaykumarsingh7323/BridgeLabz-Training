package com.functionalinterface.functionalinterfaces.temperaturealertsystem;

import java.util.function.Predicate;

public class TemperatureAlertSystem {

    public static void main(String[] args) {

        double threshold = 37.5;  

        Predicate<Double> isHighTemperature = (temp) -> temp > threshold;

        double[] readings = {36.8, 37.2, 37.6, 38.1};

        for (double temp : readings) {
            if (isHighTemperature.test(temp)) {
                System.out.println("ALERT! High temperature: " + temp + "°C");
            } else {
                System.out.println("Normal temperature: " + temp + "°C");
            }
        }
    }
}
