package com.hashmapandhashfunction.twosum;

import java.util.*;

class TwoSum {

    public static int[] twoSum(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int required = target - arr[i];

            if (map.containsKey(required)) {
                return new int[]{ map.get(required), i };
            }

            map.put(arr[i], i);
        }

        return new int[]{ -1, -1 }; 
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

        int[] result = twoSum(arr, target);

        if (result[0] != -1) {
            System.out.println("Indices: " + result[0] + " , " + result[1]);
            System.out.println("Values: " + arr[result[0]] + " + " + arr[result[1]]);
        } else {
            System.out.println("No valid pair found.");
        }
    }
}

