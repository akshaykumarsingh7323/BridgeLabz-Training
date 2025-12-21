import java.util.*;

// Create a class to reverse a number

public class ReverseNumber {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = kb.nextInt();

        int temp = number;
        int count = 0;

        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        int[] digits = new int[count];

        temp = number;
        int index = 0;

        while (temp != 0) {
            digits[index] = temp % 10;
            temp = temp / 10;
            index++;
        }

	// Displaying the result number

        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }
    }
}
