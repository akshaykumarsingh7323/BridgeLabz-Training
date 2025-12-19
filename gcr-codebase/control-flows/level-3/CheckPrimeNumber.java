import java.util.*;

// create a class to check the prime number

public class CheckPrimeNumber{
    public static void main(String args []){
	boolean isPrime = true;
	
	// Get input from the user 

	Scanner kb = new Scanner(System.in);
	System.out.println("Enter a number:");
	int number = kb.nextInt();	
	
	if(number <= 1){
	   System.out.println("Not Prime");
	}else{
	   for(int i = 2; i < number;i++){
	       if(number % i == 0){
	   	   isPrime = false;
		   break;
	       }
	   }
	}

	if(isPrime){
	   System.out.println("Prime Number");
	}else{
	    System.out.println("Not Prime Number");
	}
    }
}