package com.sorting.insertionsort;

public class InsertionSort {

    public static void sort(PackageItem[] packages) {
        for (int i = 1; i < packages.length; i++) {
            PackageItem key = packages[i];
            int j = i - 1;

            while (j >= 0 && packages[j].getWeight() > key.getWeight()) {
                packages[j + 1] = packages[j];
                j--;
            }
            packages[j + 1] = key;
        }
    }
}
