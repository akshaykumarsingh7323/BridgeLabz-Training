import java.util.*;

// create a class to find the factor of a number using while loop

public class FindFactorUsingWhileLoop{
    public static void main(String args[]){
	
	// Get input from the user, checking divisibility and displaying the number

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int number = kb.nextInt();

	int counter = 1;

	if(number < 0){

	   System.out.println("Number is negative");

	}else{

	   while(counter < number){
	       if(number % counter == 0){

		  System.out.println(counter);
	       	
	       }
		  counter++;	
	   }  
	}
    }
}