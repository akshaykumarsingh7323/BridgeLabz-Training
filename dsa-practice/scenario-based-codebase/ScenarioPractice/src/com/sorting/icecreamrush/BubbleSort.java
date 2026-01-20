package com.sorting.icecreamrush;

class BubbleSort {

    static void sortByPopularity(Flavor[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].sales < arr[j + 1].sales) {
                    Flavor temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
