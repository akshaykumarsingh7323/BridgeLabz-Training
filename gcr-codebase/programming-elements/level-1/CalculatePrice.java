import java.util.*;

// create a class CalculatePrice to calculate the price of the items
public class CalculatePrice{
     public static void main(String args []){

	//Taking unit price and quantity of item from the user and calculate total price
	Scanner kb = new Scanner(System.in);

	System.out.println("Enter price of 1 item:");
	int price = kb.nextInt();
	
	System.out.println("Enter quantity of items:");
	int quantity = kb.nextInt();

	int totalPrice = price * quantity;

	// Display the result on the screen
	System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + price);
     }
}

