import java.util.*;

// create a class to find the all multiple of a number using while loop

public class FindMultipleUsingWhileLoop{
    public static void main(String args[]){
	
	// Get input from the user, and find all the multiples

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int number = kb.nextInt();

	int counter = number - 1;

	if(number < 0 || number >= 100){

	   System.out.println("Please input number >0 and <100");

	}else{

	   while(counter > 1){

	       if(number % counter == 0){
		  System.out.println(counter);
	       
	       }
		counter--;

	   }  
	}
    }
}

