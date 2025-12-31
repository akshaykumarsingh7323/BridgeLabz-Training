/*
	18. Currency Exchange Kiosk 💱
	Design a currency converter:
	● Take INR amount and target currency.
	● Use a switch to apply the correct rate.
	● Ask if the user wants another conversion (do-while).
*/

import java.util.*;
public class CurrencyExchange{
    public static void main(String args []){
		System.out.println("\n---------------------------------------");
		System.out.println("---------- Currency Exchange ----------");
		System.out.println("---------------------------------------\n");
		
		Scanner sc = new Scanner(System.in);
		
		String currency[] = {"United State Doller (USD)", "European Union (EURO)", "Japanese Yen (JPY)", "Russian Rubble (RUB)", "Chinese Yaun (CNY)"};
		double rate[] = {0.011, 0.0095, 1.74, 0.90, 0.078};
		
		boolean conversion = true;
		
		do {
			System.out.print("Enter INR : ");
			int inr = sc.nextInt();
			
			System.out.println("\n");
			for(int i=0; i<currency.length; i++) {
				System.out.println("Press " + (i+1) + " for " + currency[i]);
			}
			
			System.out.println("\nChoose either 1, 2, 3, 4, or 5 to convert currency : ");
			int choice = sc.nextInt();
			
			while(choice < 1 || choice > 5){
				System.out.println("\nInvalid Choice!!, Please Input Valid Number: ");
				choice = sc.nextInt();
			}
			
			switch(choice) {
				case 1 -> System.out.println("\nThe comnversion of " + inr + " INR into USD is : " + (rate[0] * inr));
				case 2 -> System.out.println("\nThe comnversion of " + inr + " INR into EURO is : " + (rate[1] * inr));
				case 3 -> System.out.println("\nThe comnversion of " + inr + " INR into JPY is : " + (rate[2] * inr));
				case 4 -> System.out.println("\nThe comnversion of " + inr + " INR into RUB is : " + (rate[3] * inr));
				case 5 -> System.out.println("\nThe comnversion of " + inr + " INR into CNY is : " + (rate[4] * inr));
				default -> System.out.println("\nInvalid Choice!!!");
			}
			
			System.out.println("\nDO you want again to convert currency? Yes or No.\n");
			String option = sc.next();
			
			if(!option.equalsIgnoreCase("yes")) conversion = false;
		} while(conversion);
	}
}


