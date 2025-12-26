import java.util.*;

public class CoffeeBill{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        final double GST_RATE = 0.18;
        boolean serving = true;

        System.out.println("=== Welcome to Ravi's Café ===");

        while(serving){

            System.out.print("Enter coffee type (espresso / latte / cappuccino) or type 'exit' to stop: ");
            String coffeeType = sc.next().toLowerCase();

            if(coffeeType.equals("exit")){
                System.out.println("Counter closed. Thank you for visiting.");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            double pricePerCup;

            switch(coffeeType){
                case "espresso":
                    pricePerCup = 120.0;
                    break;
                case "latte":
                    pricePerCup = 150.0;
                    break;
                case "cappuccino":
                    pricePerCup = 140.0;
                    break;
                default:
                    System.out.println("Invalid coffee type. Please try again.");
                    continue; 
            }

            double subtotal = pricePerCup * quantity;
            double gst = subtotal * GST_RATE;
            double totalBill = subtotal + gst;

            System.out.println("\n----- Bill Details -----");
            System.out.println("Coffee: " + coffeeType);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price per cup: " + pricePerCup);
            System.out.println("Subtotal: " + subtotal);
            System.out.println("GST (18%): " + gst);
            System.out.println("Total Bill: " + totalBill);
            System.out.println("------------------------\n");
        }
    }
}