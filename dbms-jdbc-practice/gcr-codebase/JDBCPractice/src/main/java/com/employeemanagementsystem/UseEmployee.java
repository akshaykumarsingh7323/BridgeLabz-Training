package com.employeemanagementsystem;

import java.util.Scanner;

public class UseEmployee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Employee Management =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search by Name");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("\nEnter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    EmployeeCRUD.addEmployee(name, salary);
                    break;

                case 2:
                    EmployeeCRUD.viewEmployees();
                    break;

                case 3:
                    System.out.print("\nEnter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    EmployeeCRUD.updateSalary(id, newSalary);
                    break;

                case 4:
                    System.out.print("\nEnter ID to Delete: ");
                    int deleteId = sc.nextInt();
                    EmployeeCRUD.deleteEmployee(deleteId);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("\nEnter Name to Search: ");
                    String searchName = sc.nextLine();
                    EmployeeCRUD.searchByName(searchName);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
