package com.sortingalgorithm.selectionsort;

public class SelectionSort {

    public static void selectionSort(int[] scores) {

        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] examScores = { 78, 92, 65, 88, 70 };

        System.out.println("Before Sorting:");
        printArray(examScores);

        selectionSort(examScores);

        System.out.println("\nAfter Sorting:");
        printArray(examScores);
    }

    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}
