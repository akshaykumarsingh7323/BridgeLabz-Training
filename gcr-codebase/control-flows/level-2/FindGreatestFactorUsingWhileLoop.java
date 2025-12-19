import java.util.*;

// Create a class to find greatest factor of a number using while loop

public class FindGreatestFactorUsingWhileLoop{
    public static void main(String args []){

	// Get input from the user and finding greatest factor

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a Number:");
	int number = kb.nextInt();

	int num = number-1;

	int greatestFactor = 1; 

	while(num > 1){

	   if(number % num == 0){

	       	greatestFactor = num;
		break;

	   } 
		num--;
	}

	// Display the output

	System.out.println("Greatest Factor is "+ greatestFactor);
    }
}


