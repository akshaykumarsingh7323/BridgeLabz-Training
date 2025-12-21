import java.util.*;

public class ChocolateDistribution {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;   
        int remainder = number % divisor;  

        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = kb.nextInt();

        System.out.print("Enter number of children: ");
        int numberOfChildren = kb.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        // Display Output
        System.out.println("Each child will get " + result[0] + " chocolates");
        System.out.println("Remaining chocolates = " + result[1]);
    }
}
