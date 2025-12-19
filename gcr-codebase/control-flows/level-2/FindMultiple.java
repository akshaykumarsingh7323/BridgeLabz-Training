import java.util.*;

// create a class to find the all multiple of a number

public class FindMultiple{
    public static void main(String args[]){
	
	// Get input from the user, and find all the multiples

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int number = kb.nextInt();

	if(number < 0 || number >= 100){

	   System.out.println("Please input number >0 and <100");

	}else{

	   for(int i = 100; i >= 1; i--){
	       if(number % i == 0){
		  System.out.println(i);
	       
	       }	
	   }  
	}
    }
}