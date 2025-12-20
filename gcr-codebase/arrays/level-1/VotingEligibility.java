import java.util.*;

// create a class to check eligibility for voting

public class VotingEligibility{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	int age [] = new int [10];

	// Taking input from the user and assign in array using for loop

	System.out.println("Enter age of 10 students:");
	for(int i = 0; i < 10; i++){
	    age[i] = kb.nextInt();
	}

	// checking eligibility and displaying

	for(int i = 0; i < 10; i++){
	    if(age[i] < 0){
	       System.out.println("Invalid age!");
	    }else if(age[i] >= 18){
	       System.out.println("The student with the age " + age[i] + " can vote");
	    }else{
	       System.out.println("The student with the age " + age[i] + " cannot vote");
	    }
	}
    }
}