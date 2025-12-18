import java.util.*;

// This class will take an input for countdown

public class CountDown{
    public static void main(String args []){

	// declare a variable and asign the value taken by user 

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a Number:");
	int counter = kb.nextInt();

	// This loop will iterate multiple time and print counter each time

	while(counter >=1){

	   System.out.println(counter);
	   counter--;
	}
    }
}
