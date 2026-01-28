package com.birdsanctuary;

import java.util.Scanner;

public class UseBirdSanctuary {

    public static void main(String[] args) {

        BirdSanctuary sanctuary = new BirdSanctuary();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nWelcome to EcoWing Bird Sanctuary");
            System.out.println("1. Add Bird");
            System.out.println("2. Display All Birds");
            System.out.println("3. Display All Flying Birds");
            System.out.println("4. Display All Swimming Birds");
            System.out.println("5. Display Both Flying & Swimming Birds");
            System.out.println("6. Delete Bird by ID");
            System.out.println("7. Sanctuary Report");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Bird ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Bird Name: ");
                    String name = sc.nextLine();

                    System.out.println("1.Eagle  2.Duck  3.Penguin  4.Kiwi");
                    int type = sc.nextInt();

                    Bird bird = null;
                    if (type == 1) bird = new Eagle(id, name);
                    else if (type == 2) bird = new Duck(id, name);
                    else if (type == 3) bird = new Penguin(id, name);
                    else if (type == 4) bird = new Kiwi(id, name);
                    else {
                        System.out.println("Invalid type");
                        continue;
                    }

                    sanctuary.addBird(bird);
                    System.out.println("Bird Added");
                    AnnotationReader.printDeveloperInfo(bird);
                    break;

                case 2:
                    sanctuary.displayAllBirds();
                    break;

                case 3:
                    sanctuary.displayFlyingBirds();
                    break;

                case 4:
                    sanctuary.displaySwimmingBirds();
                    break;

                case 5:
                    sanctuary.displayFlyingAndSwimmingBirds();
                    break;

                case 6:
                    System.out.print("Enter Bird ID: ");
                    sanctuary.removeBirdById(sc.nextLine());
                    System.out.println("Bird Removed");
                    break;

                case 7:
                    sanctuary.sanctuaryReport();
                    break;

                case 8:
                    System.out.println("Exiting Sanctuary");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
