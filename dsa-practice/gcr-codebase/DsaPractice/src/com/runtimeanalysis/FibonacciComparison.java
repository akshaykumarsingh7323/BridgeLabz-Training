package com.runtimeanalysis;

import java.util.Scanner;

public class FibonacciComparison {

    // Recursive Fibonacci
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum = 0;

        if (n == 0) return 0;
        if (n == 1) return 1;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		System.out.println("\n-----------------------------------------------------------------------");
    		System.out.println("---------- Comparison between Recursive and Iterative method ----------");
    		System.out.println("-----------------------------------------------------------------------\n");
    		System.out.println("Enter a number: ");
        int n = sc.nextInt(); 
     
        // Recursive calculation
        long startRecursive = System.nanoTime();
        int recursiveResult = fibonacciRecursive(n);
        long endRecursive = System.nanoTime();

        // Iterative calculation
        long startIterative = System.nanoTime();
        int iterativeResult = fibonacciIterative(n);
        long endIterative = System.nanoTime();

        System.out.println("Given number: " + n);
        System.out.println("Recursive Result: " + recursiveResult);
        System.out.println("Iterative Result: " + iterativeResult);

        System.out.println("Recursive Time: " +
                (endRecursive - startRecursive) + " ns");

        System.out.println("Iterative Time: " +
                (endIterative - startIterative) + " ns");
    }
}
