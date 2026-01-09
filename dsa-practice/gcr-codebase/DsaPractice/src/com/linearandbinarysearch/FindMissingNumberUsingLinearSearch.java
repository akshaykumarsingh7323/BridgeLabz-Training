package com.linearandbinarysearch;

import java.util.*;

public class FindMissingNumberUsingLinearSearch {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1];

        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return n + 1;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive: " + missing);

        Arrays.sort(arr); 
        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}
