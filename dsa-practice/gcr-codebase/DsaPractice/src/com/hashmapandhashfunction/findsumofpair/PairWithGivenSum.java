package com.hashmapandhashfunction.findsumofpair;

import java.util.*;

class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int required = target - num;

            if (map.containsKey(required)) {
                System.out.println("Pair found: (" + required + ", " + num + ")");
                return true;
            }

            map.put(num, 1); 
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        if (!hasPairWithSum(arr, target)) {
            System.out.println("No pair found with the given sum.");
        }
    }
}
