package com.emergencypatientnavigation;

public class UseAmbulance {
    public static void main(String[] args) {

        AmbulanceRoute route = new AmbulanceRoute();

        route.addUnit("Emergency", false);
        route.addUnit("Radiology", false);
        route.addUnit("Surgery", true);
        route.addUnit("ICU", false);

        route.displayRoute();

        route.findNearestAvailableUnit();

        route.removeUnit("Radiology");
        route.displayRoute();

        route.findNearestAvailableUnit();
    }
}
