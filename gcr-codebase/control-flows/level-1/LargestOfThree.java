import java.util.*;																	

// create a class LargestOfThree to check the largest number	

public class LargestOfThree{
    public static void main(String args []){

        // taking input from the user and check the largest number 

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter first number:");
	int number1 = kb.nextInt();

	System.out.println("Enter second number:");
	int number2 = kb.nextInt();

	System.out.println("Enter third number:");
	int number3 = kb.nextInt();

	// Display the output on the screen "true" or "false"

	System.out.println("Is the first number the largest? " + (number1 > number2 && number1 > number3));

	System.out.println("Is the second number the largest? " + (number2 > number1 && number2 > number3));

	System.out.println("Is the first third the largest? " + (number3 > number1 && number3 > number2));


    }
}


