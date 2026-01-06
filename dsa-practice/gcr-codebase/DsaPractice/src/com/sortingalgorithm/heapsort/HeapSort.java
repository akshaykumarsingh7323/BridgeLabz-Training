package com.sortingalgorithm.heapsort;

public class HeapSort {

    public static void heapSort(int[] salaries) {

        int n = salaries.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            heapify(salaries, i, 0);
        }
    }

    private static void heapify(int[] arr, int heapSize, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {

            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, heapSize, largest);
        }
    }

    public static void main(String[] args) {

        int[] salaryDemands = { 75000, 50000, 120000, 90000, 60000 };

        System.out.println("Before Sorting:");
        printArray(salaryDemands);

        heapSort(salaryDemands);

        System.out.println("\nAfter Sorting:");
        printArray(salaryDemands);
    }

    public static void printArray(int[] arr) {
        for (int salary : arr) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }
}
