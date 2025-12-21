import java.util.*;

// create a program to find the frequency of the digits

public class DigitFrequency {
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


        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }

        int[] frequency = new int[10];

        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        // Display frequency

        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " : " + frequency[i]);
            }
        }
    }
}
