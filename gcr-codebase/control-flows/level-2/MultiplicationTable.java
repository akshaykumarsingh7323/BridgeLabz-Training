import java.util.*;

// create a class to find multiplication table of a number 

public class MultiplicationTable{
    public static void main(String args []){

	// Get input from the user

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a number:");
	int number = kb.nextInt();

	//multiply and display multiplication table

	for(int i = 6 ; i <= 9 ; i++){
            System.out.println(number + " * " + i + " = " + (number * i));
	}
    }
}