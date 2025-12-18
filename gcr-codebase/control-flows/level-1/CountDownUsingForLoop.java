import java.util.*;

//create a class for countdown using for loop

public class CountDownUsingForLoop{
    public static void main(String args []){

	// taking input from the user and assign in counter variable

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int counter = kb.nextInt();

	// This for loop will iterate multiple time and print value of i each time

	for(int i = counter ; i >= 1 ; i--){

	    System.out.println(i);

	}
    }
}