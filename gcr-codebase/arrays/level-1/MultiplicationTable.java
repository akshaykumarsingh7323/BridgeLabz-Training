import java.util.*;

// Create a class to find table of a number

public class MultiplicationTable{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);
	
        System.out.println("Enter a number");
	int number = kb.nextInt();
	int arr [] = new int [10];

	// multiple of that are assign in the array using for loop

	System.out.println("Enter 5 numbers:");
	for(int i = 0; i < 10; i++){
	    arr[i] = number * (i + 1);
	}

	// Displaying the output

	for(int i = 0; i < 10; i++){
	    System.out.println(number + " * " + (i + 1) + " = " + arr[i]);
	}
    }
}

