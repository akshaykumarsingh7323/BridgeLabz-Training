import java.util.*;

// create class NaturalNumberSum2 to check natural number and calculate sum of n natural number by while loop and formulae

public class NaturalNumberSum2{
    public static void main(String args []){
	
	// input from user and assign in variable, checking natural number, and find the sum of n natural number

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int n = kb.nextInt();

	int sum1 = 0;
	int sum2 = n * (n + 1) / 2;
	
	if(n > 0){

	   while(n > 0){
	        sum1 = sum1 + n;
		n--;	
	   }

           // compare sum of n natural number by while loop and formulae	   

	   System.out.println("The sum of " + n + " natural number by while loop and formulae is same? " + (sum1 == sum2));

	}else{

	   System.out.println("The number " + n  + " is not a natural number");

	}

    }
}






