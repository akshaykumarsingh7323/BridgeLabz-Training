import java.util.*;

//create class to check a number is positive, negative, or zero

public class CheckNumber{
    public static void main(String args[]){

	// taking input and checking number and displaying the result

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int number = kb.nextInt();

	if(number > 0){

	   System.out.println("Positive");
	
	}else if(number < 0){

	   System.out.println("Negative");

	}else{

	   System.out.println("Zero");

	}

    }
}

