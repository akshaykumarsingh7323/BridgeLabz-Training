package com.binarysearchtree.UniversityRecordSystem;

import java.util.Scanner;

public class UseUniversity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentBST bst = new StudentBST();
        int choice;

        do {
            System.out.println("\n--- University Digital Record System ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display Students (Sorted)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    bst.insert(new Student(roll, name));
                    System.out.println("Student inserted.");
                    break;

                case 2:
                    System.out.print("Enter Roll No to delete: ");
                    bst.delete(sc.nextInt());
                    System.out.println("Student deleted (if existed).");
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    Student s = bst.search(sc.nextInt());
                    if (s != null) {
                        System.out.println("Found → Roll No: " +
                                s.getRollNo() +
                                ", Name: " +
                                s.getName());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    bst.displaySorted();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
