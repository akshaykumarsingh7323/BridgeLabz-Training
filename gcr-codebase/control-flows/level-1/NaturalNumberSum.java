import java.util.*;

// create class NaturalNumberSum to check natural number and calculate sum of n natural number

public class NaturalNumberSum{
    public static void main(String args []){
	
	// input from user and assign in variable, checking natural number, and find the sum of n natural number and displaying

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int n = kb.nextInt();
	
	if(n > 0){

	   int sum = n * (n + 1) / 2;
	   System.out.println("The sum of " + n + " natural numbers is " + sum);

	}else{

	   System.out.println("The number " + n  + " is not a natural number");

	}
    }
}






