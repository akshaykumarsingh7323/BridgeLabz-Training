package com.payxpress;

import java.util.*;

public class UsePayXpress {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bill bill = null;

        System.out.println("Choose Bill Type:");
        System.out.println("1. Electricity");
        System.out.println("2. Water");
        System.out.println("3. Internet");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter due date: ");
        String dueDate = sc.nextLine();

        switch (choice) {
            case 1:
                bill = new ElectricityBill(amount, dueDate);
                break;
            case 2:
                bill = new WaterBill(amount, dueDate);
                break;
            case 3:
                bill = new InternetBill(amount, dueDate);
                break;
            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }

        bill.sendReminder();

        System.out.print("\nEnter late penalty (if any): ");
        double penalty = sc.nextDouble();
        double total = bill.calculateLateFee(penalty);

        System.out.println("Total amount to pay: " + total);

        System.out.print("Do you want to pay now? (yes/no): ");
        sc.nextLine();
        String payChoice = sc.nextLine();

        if (payChoice.equalsIgnoreCase("yes")) {
            bill.pay();
        } else {
            System.out.println("Payment pending.");
        }

        sc.close();
    }
}
