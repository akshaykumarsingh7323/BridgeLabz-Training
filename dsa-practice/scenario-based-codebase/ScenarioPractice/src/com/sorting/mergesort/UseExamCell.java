package com.sorting.mergesort;

import java.util.*;

public class UseExamCell {

    public static void main(String[] args) {
    	System.out.println("\n---------- Student Rank Generator ----------\n");
        Scanner sc = new Scanner(System.in);
        RankService service = new RankService();

        System.out.println("\nEnter number of students: ");
        int n = 0;
        try {
        	
            n = sc.nextInt();
        } catch (InputMismatchException e) {
        	
            System.out.println("Invalid input! Please enter numbers only.");
            sc.next(); 
            n = sc.nextInt();
        }

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter Roll No and Score for student " + (i + 1) + " :");
            int roll = sc.nextInt();
            int score = sc.nextInt();
            students[i] = new Student(roll, score);
        }

        service.generateRankList(students);
        service.displayRankList(students);
    }
}
