import java.util.*;

public class SumOfNaturalNumber {

    static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = kb.nextInt();

        int result = findSum(n);

        // Display Output
        System.out.println("Sum of first " + n + " natural numbers = " + result);
    }
}
