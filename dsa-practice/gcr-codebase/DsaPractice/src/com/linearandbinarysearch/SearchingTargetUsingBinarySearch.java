package com.linearandbinarysearch;

import java.util.Scanner;

public class SearchingTargetUsingBinarySearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int r = mid / col;
            int c = mid % col;

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Enter row and column size: ");
    		int row = sc.nextInt();
    		int col = sc.nextInt();
    		
        int[][] matrix = new int[row][col];
        for(int i = 0; i < row; i++) {
        		for(int j = 0; j < col; j++) {
        			matrix[i][j] = sc.nextInt();
        		}
        }
        
        System.out.println("Enter target to search: ");
        int target = sc.nextInt();

        System.out.println(searchMatrix(matrix, target));
    }
}
