import java.util.*;

// create a class DoubleOpt to perform operation
public class DoubleOpt{
    public static void main(String args []){

	// Declare and taking 3 numbers from the users as an input and assign in variable a, b, and c
	Scanner kb = new Scanner(System.in);

	System.out.println("Enter first number:");
	double a = kb.nextDouble();

	System.out.println("Enter second number:");
	double b = kb.nextDouble();

	System.out.println("Enter third number:");
	double c = kb.nextDouble(); 

	double operation1 = a + b *c;

	double operation2 = a * b + c;

	double operation3 = c + a / b;

	double operation4 = a % b + c; 
 
	// Displaying the output
	System.out.println("The result of the Double Operations are " + operation1	+" , " + operation2 + " , " + operation3 + " , and " + operation4); 
    }
}
