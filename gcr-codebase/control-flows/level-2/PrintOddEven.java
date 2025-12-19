import java.util.*;

// create a class to print odd and even number 

public class PrintOddEven{
    public static void main(String args []){

	//Get input from the user and checking odd or even and displaying the output

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter a Number:");
	int number = kb.nextInt();
	
	if(number <= 0){

	   System.out.println("Please enter a natural number!"); 
 
	}else{
           
	   for(int i = 1 ; i <= number ; i++){

	       if(i % 2 == 0){

		  System.out.println(i + " is an even number");

	       }else{

                  System.out.println(i + " is an odd number");
	       }	
	   }
	}
    }
}

