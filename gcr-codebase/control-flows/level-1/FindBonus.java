import java.util.*;

// Create a class to find bonus of the employee

public class FindBonus{
    public static void main(String args []){

	// Get input from the user 

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter employee salary:");
	double salary = kb.nextDouble();

	System.out.println("Enter year of service:");
	int yearOfService = kb.nextInt();

	// Calculating bonus

	if(yearOfService > 5){

	   double bonus = salary * 0.05;
	   System.out.println("Bonus amount: " + bonus);

	}else{

	   System.out.println("No Bonus");

	}
    }
}