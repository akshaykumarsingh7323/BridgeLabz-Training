package com.sorting.fitnesstracker;

import java.util.Scanner;

public class UseFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users (max 20): ");
        int n = sc.nextInt();
        sc.nextLine(); 

        User[] users = new User[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter user name: ");
            String name = sc.nextLine();

            System.out.print("Enter steps taken today: ");
            int steps = sc.nextInt();
            sc.nextLine();

            users[i] = new User(name, steps);
        }

        BubbleSort.sortBySteps(users);

        System.out.println("\n🏆 Daily Step Leaderboard:");
        int rank = 1;
        for (User u : users) {
            System.out.println("Rank " + rank++ + ": " + u.name + " - " + u.steps + " steps");
        }
    }
}
