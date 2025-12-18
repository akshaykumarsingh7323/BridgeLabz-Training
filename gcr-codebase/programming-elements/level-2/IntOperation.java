import java.util.*;

// create a class IntOperation to perform operation
public class IntOperation{
    public static void main(String args []){

	// Declare and taking 3 numbers from the users as an input and assign in variable a, b, and c
	Scanner kb = new Scanner(System.in);

	System.out.println("Enter first number:");
	int a = kb.nextInt();

	System.out.println("Enter second number:");
	int b = kb.nextInt();

	System.out.println("Enter third number:");
	int c = kb.nextInt(); 

	int operation1 = a + b *c;

	int operation2 = a * b + c;

	int operation3 = c + a / b;

	int operation4 = a % b + c; 
 
	// Displaying the output
	System.out.println("The result of the Int Operations are " + operation1	+" , " + operation2 + " , " + operation3 + " , and " + operation4); 
    }
}
