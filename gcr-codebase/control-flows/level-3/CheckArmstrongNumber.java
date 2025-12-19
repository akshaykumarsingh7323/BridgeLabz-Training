import java.util.*;

// create a program to check Armstrong number

public class CheckArmstrongNumber{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	// Get input from user and assign in to number and check armstrong

	System.out.println("Enter a number: ");
	int number = kb.nextInt();  

	int originalNumber = number;
        int sum = 0; 

	while(originalNumber != 0){
	    int digit = originalNumber % 10;
            sum = sum + (digit * digit * digit);
	    originalNumber = originalNumber / 10;
	}

	// Display the output "number is Armstrong" or "Not" 
	
	if(number == sum){
            System.out.println(number + " is Armstrong Number");
	}else{
	    System.out.println(number + " is not Armstrong Number");
	}   
    }
}
