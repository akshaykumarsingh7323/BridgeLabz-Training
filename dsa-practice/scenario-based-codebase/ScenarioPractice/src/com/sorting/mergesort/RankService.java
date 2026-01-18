package com.sorting.mergesort;

public class RankService {

    public void generateRankList(Student[] students) {
        MergeSort.mergeSort(students, 0, students.length - 1);
    }

    public void displayRankList(Student[] students) {
        System.out.println("\nState Level Rank List:");
        int rank = 1;
        for (Student s : students) {
            System.out.println("Rank " + rank++ +
                    " | Roll No: " + s.getRollNo() +
                    " | Score: " + s.getScore());
        }
    }
}
