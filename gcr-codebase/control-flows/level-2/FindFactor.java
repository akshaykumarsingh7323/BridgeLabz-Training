import java.util.*;

// create a class to find the factor of a number

public class FindFactor{
    public static void main(String args[]){
	
	// Get input from the user, checking divisibility and displaying the number

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int number = kb.nextInt();

	if(number < 0){

	   System.out.println("Number is negative");

	}else{

	   for(int i = 1; i < number; i++){
	       if(number % i == 0){
		  System.out.println(i);
	       
	       }	
	   }  
	}
    }
}