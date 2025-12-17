import java.util.Scanner;
//This class FeeDiscount calculates the discount amount and final fee a student has to pay after applying a percentage discount
public class FeeDiscount{
    public static void main(String args []){

        //variable declare and  and taking input from the user
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter fee:");
        int fee = kb.nextInt();
        System.out.println("Enter discount percentage:");
        double discountPercent = kb.nextDouble();
        double discount = (fee * discountPercent)/100;
        double payableFee = fee - discount;

        //This line will display the discount amount and final fee a student have to pay
	System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+payableFee);
    }
}
