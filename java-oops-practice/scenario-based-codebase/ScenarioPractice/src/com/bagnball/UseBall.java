package com.bagnball;

import java.util.ArrayList;
import java.util.Scanner;

public class UseBall {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Bag> bags = new ArrayList<>();

        while (true) {

            System.out.println("\nTinyTown Bag-n-Ball Organizer");
            System.out.println("1. Add Bag");
            System.out.println("2. Add Ball to Bag");
            System.out.println("3. Remove Ball from Bag");
            System.out.println("4. Display Balls in Bag");
            System.out.println("5. Display All Bags");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Bag ID: ");
                    String bagId = sc.nextLine();

                    System.out.print("Enter Bag Color: ");
                    String bagColor = sc.nextLine();

                    System.out.print("Enter Capacity: ");
                    int capacity = sc.nextInt();

                    bags.add(new Bag(bagId, bagColor, capacity));
                    System.out.println("Bag added");
                    break;

                case 2:
                    System.out.print("Enter Bag ID: ");
                    String bId = sc.nextLine();

                    Bag selectedBag = findBag(bags, bId);
                    if (selectedBag == null) {
                        System.out.println("Bag not found");
                        break;
                    }

                    System.out.print("Enter Ball ID: ");
                    String ballId = sc.nextLine();

                    System.out.print("Enter Ball Color: ");
                    String ballColor = sc.nextLine();

                    System.out.print("Enter Ball Size: ");
                    String size = sc.nextLine();

                    selectedBag.addBall(new Ball(ballId, ballColor, size));
                    break;

                case 3:
                    System.out.print("Enter Bag ID: ");
                    bId = sc.nextLine();

                    selectedBag = findBag(bags, bId);
                    if (selectedBag == null) {
                        System.out.println("Bag not found");
                        break;
                    }

                    System.out.print("Enter Ball ID to remove: ");
                    String removeId = sc.nextLine();
                    selectedBag.removeBall(removeId);
                    break;

                case 4:
                    System.out.print("Enter Bag ID: ");
                    bId = sc.nextLine();

                    selectedBag = findBag(bags, bId);
                    if (selectedBag != null)
                        selectedBag.displayBalls();
                    else
                        System.out.println("Bag not found");
                    break;

                case 5:
                    for (Bag bag : bags) {
                        bag.displayInfo();
                    }
                    break;

                case 6:
                    System.out.println("Exiting TinyTown System");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static Bag findBag(ArrayList<Bag> bags, String id) {
        for (Bag bag : bags) {
            if (bag.getBagId().equals(id))
                return bag;
        }
        return null;
    }
}
