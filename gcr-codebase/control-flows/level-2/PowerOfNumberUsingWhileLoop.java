import java.util.*;

// create a class PowerOfNumberUsingWhileLoop using while loop to find the power of a number

public class PowerOfNumberUsingWhileLoop{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	//Get input from the user

	System.out.println("Enter number and power:");
	int number = kb.nextInt();
	int power = kb.nextInt();

	int result = 1;
	int counter = 0;

	if(number <= 0 || power <= 0){

	   System.out.println("Please input positive number!");

	}else{
	   
	    while(counter != power){
		result = number * result;
		counter++;	
	    }
	}

	// Displaying the output

	System.out.println(result);
   }
}