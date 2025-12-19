import java.util.*;

// Create a class to find greatest factor of a number

public class FindGreatestFactor{
    public static void main(String args []){

	// Get input from the user and finding greatest factor

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a Number:");
	int number = kb.nextInt();

	int greatestFactor = 1; 

	for(int i = number - 1; i >= 1; i--){

	   if(number % i == 0){
	       	greatestFactor = i;
		break;

	   } 
	}

	// Display the output

	System.out.println("Greatest Factor is "+ greatestFactor);
    }
}


