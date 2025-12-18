import java.util.*;

//create class CheckSmallest to check the first number is smallest of all three number

public class CheckSmallest{
    public static void main(String args []){

	//creating object of Scanner class and declare variable and taking input from the user

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter first number:");
	int number1 = kb.nextInt();

	System.out.println("Enter second number:");
	int number2 = kb.nextInt();

	System.out.println("Enter third number:");
	int number3 = kb.nextInt();

	// Display the output "true" or "false"

	System.out.println("Is the first number the smallest? " + (number1 < number2 && number1 < number3));		
   }
}


