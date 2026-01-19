package com.sorting.cropmonitor;

class QuickSort {

    static int partition(SensorReading[] arr, int low, int high) {
        long pivot = arr[high].timestamp;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].timestamp <= pivot) {
                i++;
                SensorReading temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        SensorReading temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(SensorReading[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
