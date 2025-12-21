import java.util.*;

// create a program to find the largest and smallest numbert and increasing the size of the array dynamically

public class LargestDigit2 {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = kb.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        int largest = 0;
        int secondLargest = 0;

        while (number != 0) {

            if (index == maxDigit) {
                maxDigit = maxDigit + 10;

                int[] temp = new int[maxDigit];

                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp;
            }

            digits[index] = number % 10; 
            number = number / 10;                    index++;
        }

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

	//Display the output

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

    }
}
