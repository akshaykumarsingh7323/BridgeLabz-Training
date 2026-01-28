package com.medwarehouse;

public class MergeSorter {

    public static void mergeSort(Medicine[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr, start, mid, end);
        }
    }

    private static void merge(Medicine[] arr, int start, int mid, int end) {

        int n1 = mid - start + 1;
        int n2 = end - mid;

        Medicine[] left = new Medicine[n1];
        Medicine[] right = new Medicine[n2];

        for (int i = 0; i < n1; i++)
            left[i] = arr[start + i];

        for (int j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (left[i].expiryDate <= right[j].expiryDate)
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < n1)
            arr[k++] = left[i++];

        while (j < n2)
            arr[k++] = right[j++];
    }
}

