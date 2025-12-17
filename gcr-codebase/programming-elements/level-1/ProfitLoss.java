// Create ProfitLoss Class to find profit or loss
public class ProfitLoss{
   public static void main(String args[]){ 

      // declare and initialize costPrice and sellingPrice
      double costPrice = 129;
      double sellingPrice = 191;  
      double profit = sellingPrice - costPrice;
      double profitPercentage = (profit/costPrice)*100; 
             
      // Display the result on the screen
      System.out.println("The Cost price is INR "+costPrice+" and Selling price is INR "+sellingPrice+ "\nThe profit is INR "+profit+" and the Profit Percentage is "+profitPercentage);   
   }
} 
