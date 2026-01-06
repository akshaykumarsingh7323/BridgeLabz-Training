package com.sortingalgorithm.quicksort;

public class QuickSort {

    public static void quickSort(double[] prices, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    private static int partition(double[] prices, int low, int high) {

        double pivot = prices[high]; // pivot element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;

                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        double[] productPrices = { 1299.99, 499.50, 899.00, 299.99, 699.75 };

        System.out.println("Before Sorting:");
        printArray(productPrices);

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("\nAfter Sorting:");
        printArray(productPrices);
    }

    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}
