import java.util.*;

// create a class to find the FactorialUsingForLoop of a number by using for loop

public class FactorialUsingForLoop{
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

	    for( ; n > 1 ; n--){
	       factorial = factorial * n;
	    }

	    // Display the result on the screen

            System.out.println("Factorial of " + number + " is : "+factorial);

	 }   	
    }
}