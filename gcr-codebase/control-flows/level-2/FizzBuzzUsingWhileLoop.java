import java.util.*;

// create a class to find FizzBuzz using while loop 

public class FizzBuzzUsingWhileLoop{
    public static void main(String args []){

	// Get input from the user

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int n = kb.nextInt();

	// Checking negative/positive and divisibility and Display result

	if(n < 0){
           System.out.println("Number is negative");
	}else{

	    while(n >= 1){

                if(n % 3 == 0 && n % 5 == 0){

		   System.out.println(n +" FizzBuzz");

		}else if(n % 3 == 0){

		   System.out.println(n +" Fizz");

		}else if(n % 5 == 0){

		   System.out.println(n +" Buzz");
		}
		  n--;
	    }
	}
    }
}
