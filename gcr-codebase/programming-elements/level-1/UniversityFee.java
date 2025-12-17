//This class UniversityFee calculates the discount amount and final fee a student has to pay after applying a percentage discount
public class UniversityFee{
    public static void main(String args []){

        //variable declare and initialize with original fee and discount percent
        int fee = 125000;
        double discountPercent = 10;
        double discount = (fee * discountPercent)/100;
        double payableFee = fee - discount;

        //This line will display the discount amount and final fee a student have to pay
	System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+payableFee);
    }
}








