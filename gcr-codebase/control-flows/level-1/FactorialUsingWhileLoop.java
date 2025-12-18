import java.util.*;

// create a class to find the Factorial of a number given by user

public class FactorialUsingWhileLoop{
    public static void main(String args []){

	// taking the input and checking negative/positive number and finding the factorial

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a Number:");
	int n = kb.nextInt();

	int factorial = 1;
	int number = n;
        
        if(n < 0){
 
	    System.out.println("It's a negative number");

	}else{

	    while(n > 1){
	       factorial = factorial * n;
	         n--;

	    }

	    // Display the result on the screen

            System.out.println("Factorial of " + number + " is : "+factorial);

	 }
   	
    }
}