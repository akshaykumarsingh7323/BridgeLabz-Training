import java.util.*;

// create a class and taking input from the user to find maximun number of handshakes
public class MaxHandshakes{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	// declare variable and assign the value taking from the user
	System.out.println("Enter number of the students:");
	int n = kb.nextInt();	

	int maxHandshakes = (n * (n - 1)) / 2;

	//Display the number of possible handshakes.
        System.out.println("The number of possible handshakes is "+maxHandshakes);
    }
}


