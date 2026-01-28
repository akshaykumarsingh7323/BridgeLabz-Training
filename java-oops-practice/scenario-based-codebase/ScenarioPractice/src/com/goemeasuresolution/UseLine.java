package com.goemeasuresolution;

import java.util.ArrayList;
import java.util.Scanner;

public class UseLine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Line> lines = new ArrayList<>();

        while (true) {

            System.out.println("\nGeoMeasure Solutions");
            System.out.println("1. Add Line");
            System.out.println("2. Compare Last Two Lines");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter x1 y1 x2 y2: ");
                double x1 = sc.nextDouble();
                double y1 = sc.nextDouble();
                double x2 = sc.nextDouble();
                double y2 = sc.nextDouble();

                Line line = new Line(x1, y1, x2, y2);
                lines.add(line);

                System.out.println("Line added");
                line.display();
            }

            else if (choice == 2) {

                if (lines.size() < 2) {
                    System.out.println("Add at least two lines first");
                    continue;
                }

                Line l1 = lines.get(lines.size() - 2);
                Line l2 = lines.get(lines.size() - 1);

                System.out.println("\nComparing Lines:");
                l1.display();
                l2.display();

                int result = l1.compareTo(l2);

                if (result == 0)
                    System.out.println("Both lines are equal in length");
                else if (result > 0)
                    System.out.println("First line is longer");
                else
                    System.out.println("Second line is longer");
            }

            else if (choice == 3) {
                System.out.println("Exiting GeoMeasure");
                sc.close();
                break;
            }

            else {
                System.out.println("Invalid choice");
            }
        }
    }
}

