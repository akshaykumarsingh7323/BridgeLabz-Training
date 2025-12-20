import java.util.*;

//Create a program to save odd and even numbers into odd and even arrays between 1 to the number entered by the user
public class FindOddEven{
    public static void main(String args []){
	Scanner kb = new Scanner(System.in);
	System.out.println("Enter a number:");
	int number = kb.nextInt();

	int odd [] = new int [(number / 2) + 1];
	int even [] = new int [(number / 2) + 1];

	int od = 0;
	int ev = 0;

	//Check number and find odd / even number
	if(number <= 0){
	    System.out.println("Not Natural number:");	
	}else{
	    for(int i = 1;i <= number; i++){
	        if(i % 2 == 0){
	 	    even[ev++] = i;
		}else{
		    odd[od++] = i;
		}
	    } 
	}

	// Displaying the output
	System.out.print("Odd Number: ");
	for(int i = 0;i < (number / 2) + 1; i++){
            System.out.print(" "+odd[i]);
	}

	System.out.println();

	
	System.out.print("Even Number: ");
	for(int i = 0;i < (number / 2) + 1; i++){
	    System.out.print(" "+even[i]);
	}

    }
}