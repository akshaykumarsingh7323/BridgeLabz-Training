package com.hashmapandhashfunction.longestconsecutivesequence;

import java.util.*;

class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] arr) {

        if (arr.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
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

        int result = longestConsecutive(arr);
        System.out.println("Length of Longest Consecutive Sequence: " + result);

        sc.close();
    }
}
