package com.sorting.bookarrangementusinginsertionsort;

import java.util.LinkedList;
public class InsertionSort {
	public static void insertionSort(LinkedList<String> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            String key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareToIgnoreCase(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);

        }
        System.out.println(list);
    }
}
