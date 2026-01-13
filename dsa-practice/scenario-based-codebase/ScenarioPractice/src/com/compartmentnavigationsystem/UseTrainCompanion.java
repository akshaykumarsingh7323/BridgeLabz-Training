package com.compartmentnavigationsystem;

import java.util.Scanner;

public class UseTrainCompanion {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        TrainCompanion train = new TrainCompanion();
        
        System.out.println("Enter number of compartment: ");
        int num  =  sc.nextInt();
        
        System.out.println("Enter compartment: ");
        for (int i = 0; i < num; i++) {
             train.addCompartment(sc.next());
        }

        train.displayTrain();
        
        System.out.println("Enter compartment to search: ");
        String choice = sc.next();
        
        Compartment current = train.searchCompartment("S2");

        train.showAdjacent(current);

        current = train.moveNext(current);
        System.out.println("\nMoved to: " + current.name);

        train.removeCompartment("Pantry");
        train.displayTrain();
    }
}

