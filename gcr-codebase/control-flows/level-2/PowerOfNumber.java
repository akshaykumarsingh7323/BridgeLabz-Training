import java.util.*;

// create a class PowerOfNumber to find the power of number using for loop

public class PowerOfNumber{
   public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	//input from the user

	System.out.println("Enter number and power:");
	int number = kb.nextInt();
	int power = kb.nextInt();

	int result = 1;

	if(number <= 0 || power <= 0){

	   System.out.println("Please input positive number!");

	}else{
	   
	    for(int i = 1; i <= power; i++){
		result = number * result;
	
	    }
	}
	System.out.println(result);
   }
}