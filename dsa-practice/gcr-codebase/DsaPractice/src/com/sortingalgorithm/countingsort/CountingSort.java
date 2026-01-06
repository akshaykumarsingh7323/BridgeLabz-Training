package com.sortingalgorithm.countingsort;

// Create a class to sort Student ages
public class CountingSort {

    public static void countingSort(int[] ages) {

        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];

        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[ages.length];

        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            int index = age - minAge;
            output[count[index] - 1] = age;
            count[index]--;
        }

        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {

        int[] studentAges = { 15, 12, 18, 14, 10, 13, 15, 12 };

        System.out.println("Before Sorting:");
        printArray(studentAges);

        countingSort(studentAges);

        System.out.println("\nAfter Sorting:");
        printArray(studentAges);
    }

    public static void printArray(int[] arr) {
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }
}

