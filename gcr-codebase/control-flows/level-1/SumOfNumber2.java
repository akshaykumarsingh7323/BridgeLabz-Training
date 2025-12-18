import java.util.*;

// create a class to add all the number given by the user and stop on entering 0 or negative number

public class SumOfNumber2{
    public static void main(String args []){

	// Taking input from the user and checking positive number and add all the number

	Scanner kb = new Scanner(System.in);

	double total = 0.0;


	while(true){

	    System.out.println("Enter a Number(0 or neg to stop):");
            double number = kb.nextDouble();

	    if(number <= 0)
		break;

	    total = total + number;

        }

	// Display result after entering 0 or negative number

	System.out.println("Total Sum: " + total);
	
    }
}
