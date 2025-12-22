import java.util.*;

public class SumNaturalNumbers {

    public static int sumUsingRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumUsingRecursion(n - 1);
    }

    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = kb.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0)");
            return;
        }

        int recursiveSum = sumUsingRecursion(n);
        int formulaSum = sumUsingFormula(n);

        // Display results
        System.out.println("Sum using Recursion = " + recursiveSum);
        System.out.println("Sum using Formula   = " + formulaSum);

        // Compare results
        if (recursiveSum == formulaSum) {
            System.out.println("Result: Both computations are correct and equal.");
        } else {
            System.out.println("Result: Computations do not match.");
        }
    }
}
