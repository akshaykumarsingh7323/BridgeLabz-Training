package com.functionalinterface.markerinterface.cloningprototypeobjects;

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        VehicleModel original = new VehicleModel("Tesla Model S", 250);

        VehicleModel copy1 = (VehicleModel) original.clone();
        VehicleModel copy2 = (VehicleModel) original.clone();

        System.out.println("Original : " + original);
        System.out.println("Copy 1   : " + copy1);
        System.out.println("Copy 2   : " + copy2);
    }
}
