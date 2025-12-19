import java.util.*;

// create a class to find FizzBuzz 

public class FizzBuzz{
    public static void main(String args []){

	// Get input from the user

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int n = kb.nextInt();

	// Checking negative/positive and divisibility and Display result

	if(n < 0){
           System.out.println("Number is negative");
	}else{

	    for(int i = 1 ; i <= n ; i++){

                if(i % 3 == 0 && i % 5 == 0){

		   System.out.println(i +" FizzBuzz");

		}else if(i % 3 == 0){

		   System.out.println(i +" Fizz");

		}else if(i % 5 == 0){

		   System.out.println(i +" Buzz");
		}
	    }
	}
    }
}
