package com.sorting.eduresult;

import java.util.Scanner;

public class UseEduResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            students[i] = new Student(name, marks);
        }

        MergeSort.mergeSort(students, 0, n - 1);

        System.out.println("\nState wise Rank List:");
        int rank = 1;
        for (Student s : students) {
            System.out.println("Rank " + rank++ + ": " + s.name + " - " + s.marks);
        }
    }
}
