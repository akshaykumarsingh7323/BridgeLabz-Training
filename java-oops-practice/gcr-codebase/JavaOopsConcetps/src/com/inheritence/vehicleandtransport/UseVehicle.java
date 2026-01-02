package com.inheritence.vehicleandtransport;

public class UseVehicle {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[3];

//        vehicles[0] = new Car(180, "Petrol", 5);
//        vehicles[1] = new Truck(120, "Diesel", 12.5);
//        vehicles[2] = new Motorcycle(160, "Petrol", true);
//
//        for (Vehicle v : vehicles) {
//            v.displayInfo();  
//            System.out.println("-------------------");
//        }
        
        Vehicle v1 = new Car(180, "Petrol", 5);
        v1.displayInfo();
        System.out.println("-------------------");
        
        Vehicle v2 = new Truck(120, "Diesel", 12.5);
        v2.displayInfo();
        System.out.println("-------------------");
        
        Vehicle v3 = new Motorcycle(160, "Petrol", true);
        v3.displayInfo();
        System.out.println("-------------------");
    }
}
