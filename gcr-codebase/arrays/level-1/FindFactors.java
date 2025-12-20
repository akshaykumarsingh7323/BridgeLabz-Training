import java.util.*;

//Create a program to find the factors of a number taken as user input

public class FindFactors{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);
	System.out.println("Enter a number:");
	int number = kb.nextInt();

	int maxFactor = 10;
	int factors [] = new int [maxFactor];
	int index = 0;

	// Finding factors
        for(int i = 1; i <= number; i++){
	    if(number % i == 0){
               if(index == maxFactor){
	         maxFactor *= 2;
		 int temp [] = new int [maxFactor];
	         for(int j = 0; j < factors.length; j++){
		    temp[j] = factors[j];
	       }
		factors = temp;
	     }	
	     factors[index++] = i;     
	    }
	}

	// Display result
	System.out.print("Factors: ");
	for(int i = 0; i < index; i++){
	    System.out.print(factors[i]+" ");

	}	
    }
}