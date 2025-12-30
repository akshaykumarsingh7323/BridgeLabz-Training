/*
 10. Phone Recharge Simulator 📱
Take the user's mobile operator and amount.
 Use a switch to display offers.
 Loop to allow repeated recharges.
 Show balance after each recharge.
*/


import java.util.*;

// create a class to perform recharge operation
public class RechargeSimulator {
	
	static Scanner sc = new Scanner(System.in);
	
	// methods for recharge
	public static void rechargePhone(String operator, int plans[], int balance) {
				
		System.out.println("\n\n----------------- " + operator + " Active Plans ---------------\n");
		System.out.println("Choose a valid plan : \n");
		
		int choose = 1;
		for(int i=0; i<plans.length; i++) {
			if(plans[i] == 199 || plans[i] == 249) 
				System.out.println(choose + " : Unlimited calls + 1GB/day for 28 days, " + plans[i]);
			else if(plans[i] == 299) 
				System.out.println(choose + " : Unlimited calls + 1.5GB/day for 28 days, " + plans[i]);
			else if(plans[i] == 349) 
				System.out.println(choose + " : Unlimited calls + 2GB/day for 28 days, " + plans[i]);
			else if(plans[i] == 579 || plans[i] == 399) 
				System.out.println(choose + " : Unlimited calls + 1.5GB/day for 56 days, " + plans[i]);
			else if(plans[i] == 899) 
				System.out.println(choose + " : Unlimited calls + 2GB/day for 90 days, " + plans[i]);
			else if(plans[i] == 729) 
				System.out.println(choose + " : Unlimited calls + 1.5GB/day for 84 days, " + plans[i]);
			else if(plans[i] == 999) 
				System.out.println(choose + " : Unlimited calls + 2GB/day for 98 days, " + plans[i]);
			
			choose++;
		}
		
		int choise = sc.nextInt();
		
		if(isSufficientBalance(balance, plans[choise - 1])) {
			System.out.println("\nCongratulations! Recharge successfull");
			balance -= plans[choise - 1];
			System.out.println("Current balance is : " + balance + "\n");
		} else {
			balance = addBalance(balance);
			rechargePhone(operator, plans, balance);
		}
		
		System.out.println("Do you want to do recharge again?");
		String request = sc.next();
		
		if(request.equals("y") || request.equals("yes") || request.equals("ya") || request.equals("Y") || request.equals("Yes") || request.equals("YES")) {
			System.out.println("\n-----------------------------------------------------------------------------\n");
			recharge(balance);
		} else {
			System.out.println("\n\nThank You for using our recharge services.\n");
			System.exit(0);
		}
	}
	
	
	//check balance
	public static int addBalance(int balance) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nInsufficient Balance. \n\nPlease enter amount to add : ");
		int money = sc.nextInt();
		
		System.out.println("\nRS " + money + " added");
		
		return balance + money;
	}
	
	
	// check balance is sufficient or not
	public static boolean isSufficientBalance(int balance, int requiredBalance) {
		return balance >= requiredBalance;
	}
	
	
	public static void recharge(int balance) {
		
		// Recharge Plans for different operator
		int jioPlans[] = {249, 299, 349, 579, 729, 899, 999};
		int airtelPlans[] = {249, 299, 579, 899, 999};
		int viPlans[] = {199, 299, 579};
		int	bsnlPlans[] = {199, 299, 399};
		
		System.out.println("\nSelect Operator");
		
		// Operators
		System.out.println("1 - Jio");
		System.out.println("2 - Airtel");
		System.out.println("3 - VI");
		System.out.println("4 - BSNL");
		
		int operator = sc.nextInt();
		
		// check number is valid or not
		while(operator == 0 || operator > 4) {
			System.out.println("Please enter a valid operator!!!");
			operator = sc.nextInt();
		}

		// calling methods for the recharge 
		switch(operator) {
			case 1 -> rechargePhone("jio", jioPlans, balance);
			case 2 -> rechargePhone("airtel", airtelPlans, balance);
			case 3 -> rechargePhone("vi", viPlans, balance);
			case 4 -> rechargePhone("bsnl", bsnlPlans, balance);
		}
	}
	
	
	public static void main(String args[]) {		
		System.out.println("-------------------------------------------------------");
		System.out.println("----------------Phone Recharge Simulator---------------");
		System.out.println("-------------------------------------------------------\n");

		int balance = 0;

		recharge(balance);
	}
}