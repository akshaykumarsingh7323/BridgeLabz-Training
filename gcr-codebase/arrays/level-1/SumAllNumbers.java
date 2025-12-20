import java.util.*;

// Writing a program to add number taken from the user and stop when entered negative or 0 and show all the number and sum of all the entered number
public class SumAllNumbers{
    public static void main(String args[]){
	Scanner kb = new Scanner(System.in);
	
        double arr [] = new double[10];
	double total = 0.0;
	int index = 0;

	System.out.println("Enter 10 numbers and enter 0 or negative to stop");
	
	// Taking user input
	while(true){
	    double num = kb.nextDouble();
	    if(num <= 0) break;
            arr[index] = num;
	    index++; 
	    if(index == 10) break;
	}
	
	// displaying the output
	for(int i = 0; i < index; i++){
	   System.out.println(arr[i]);
	   total = total + arr[i];
	}
	 
	System.out.println("Sum of total numbrer is " + total);

    }
}


