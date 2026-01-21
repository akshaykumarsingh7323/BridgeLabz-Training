package com.sorting.gamerzone;

import java.util.*;

class QuickSorter {

    static void quickSort(List<Player> list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quickSort(list, low, p - 1);
            quickSort(list, p + 1, high);
        }
    }

    static int partition(List<Player> list, int low, int high) {
        int pivot = list.get(high).score;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).score >= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }
}
