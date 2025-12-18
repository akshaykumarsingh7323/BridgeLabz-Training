import java.util.*;

// create a class Division to find Quotient and Reminder
public class Division{
    public static void main(String args []){

	// declare variable and taking two numbers as an input and perform operation
	Scanner kb = new Scanner(System.in);

	System.out.println("Enter first number:");
	int number1 = kb.nextInt();

	System.out.println("Enter second number:");
	int number2 = kb.nextInt();

	int quotient = number1 / number2;
	int reminder = number1 % number2;

	// Displaying the output on the screen
	System.out.println("The Quotient is " + quotient + " and Reminder is " + reminder + " of two numbers " + number1 + " and " + number2);
    }
}

