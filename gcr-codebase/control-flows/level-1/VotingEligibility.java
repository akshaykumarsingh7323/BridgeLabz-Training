import java.util.*;

// create a class to check eligibility for vote 

public class VotingEligibility{
    public static void main(String args []){

	// Taking input from the user and checking eligibility for vote and displaying output

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter age: "); 
	int age = kb.nextInt();
	
	if(age >= 18){

	   System.out.println("The person's age is " + age + " and can vote"); 

	}else{

	   System.out.println("The person's age is " + age + " and cannot vote");

	}
	    
    }
}
