import java.util.*;

// writing a program to find the multiplication from 6 to 9 of a given number
public class DisplayMultiplicationNumber{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number =  kb.nextInt();

        int multiplicationResult [] = new int[4];

	for(int i = 0; i < 4; i++){
	    multiplicationResult[i] = number * (i + 6); 
	}

	//Displaying the output
	for(int i = 0; i < 4; i++){
	    System.out.println(number + " * " + (i + 6) + " = " + multiplicationResult[i]);
	}

    }
}