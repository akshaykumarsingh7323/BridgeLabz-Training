import java.util.*;

// Create a program to store the digits of the number in an array and find the largest and second largest element of the array

public class LargestDigit {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = kb.nextInt();

        int maxDigit = 10;                 
        int[] digits = new int[maxDigit];
        int index = 0;               


        while (number != 0) {
            if (index == maxDigit) {
                break;
            }
            digits[index] = number % 10; 
            number = number / 10;        
            index++;
        }
        
        int largest = 0;
        int secondLargest = 0;
        
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display output ont the screen

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}
