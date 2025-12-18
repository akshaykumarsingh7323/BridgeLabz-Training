import java.util.*;

// create a class to add all the number given by the user and stop on entering 0

public class SumOfNumbers{
    public static void main(String args []){

	// Taking input from the user and checking for non-zero number and add all the number

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a Number(0 to stop):");
        double number = kb.nextDouble();

	double total = 0.0;


	while(number != 0){

	    total = total + number;

	    System.out.println("Enter a Number(0 to stop):");
            number = kb.nextDouble();

        }

	// Display result after adding all the number

	System.out.println("Total Sum: " + total);
	
    }
}