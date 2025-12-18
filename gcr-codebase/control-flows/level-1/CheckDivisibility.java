import java.util.*;

// create a class to check divisibility of a number

public class CheckDivisibility{
    public static void main(String args []){

	// Declare a variable and assign value by taking from users

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int number = kb.nextInt();

	// Displaying the output "true" or "false"

        System.out.println("Is the number " + number + " divisible by 5? " + (number % 5 == 0));			  
     }
}


