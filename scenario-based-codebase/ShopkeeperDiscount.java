/* 
 Shopkeeper’s Discount Dashboard 🛍️
 A shopkeeper gives discounts based on total bill:
  Input item prices in a for-loop.
  Use if-else for discount logic.
  Use proper indentation, constants, and comments.
*/

import java.util.*;

// Create a class to calculate discount in shop
public class ShopkeeperDiscount{
    public static void main(String args []){

	Scanner sc = new Scanner(System.in);

	System.out.println("Enter number of items: ");
	int itemCount = sc.nextInt();

	double total = 0;
	double discount = 0;

	//Taking price of items using for loop
	for(int i = 1; i <= itemCount; i++){
	    System.out.println("Enter price for item " + i);
	    double price = sc.nextDouble();
	    total = total + price;
	}
		
	// Calculating discount on basis of total price
	if(total >= 4000){
           discount = total * 20 / 100;
	}else if(total >= 3000){
	   discount = total * 15 / 100;
	}else if(total >= 2000){
	   discount = total * 10 / 100;
	}else if(total >= 1000){
	   discount = total * 10 / 100;
	}else{
	   discount = total * 5 / 100;
	}

	// Display output
	System.out.println("Total Amount: " + total);
	System.out.println("Total Discount: " + discount);
	System.out.println("Final Amount: " + (total - discount));
    }
}