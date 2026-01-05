package com.hashmapandhashfunction.zerosumsubarrays;

import java.util.*;

class ZeroSumSubarrays {

    public static void findZeroSumSubarrays(int[] arr) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int prefixSum = 0;

        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        System.out.println("Zero-sum subarrays (startIndex, endIndex):");

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                for (int startIndex : map.get(prefixSum)) {
                    System.out.println("(" + (startIndex + 1) + ", " + i + ")");
                }
            }

            map.putIfAbsent(prefixSum, new ArrayList<>());
            map.get(prefixSum).add(i);
        }
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

        findZeroSumSubarrays(arr);

        sc.close();
    }
}
