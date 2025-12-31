/*
	20. Festival Lucky Draw 🎉
	At Diwali mela, each visitor draws a number.
	● If the number is divisible by 3 and 5, they win a gift.
	● Use if, modulus, and loop for multiple visitors.
	● continue if input is invalid.
*/

import java.util.*;
public class LuckyDraw{
    public static void main(String args []){
	    Scanner sc = new Scanner(System.in);
		
		System.out.println("\n---------------------------------");
		System.out.println("------ Festival Lucky Draw ------");
		System.out.println("---------------------------------\n");
		
		System.out.println("\n------You have a chance to win surprise gift ------\n");
		
		for(int i = 0; i < 10; i++){
			System.out.println("\n\nGift Remaining : " + (10 - i));
			
			System.out.print("\nEnter a number: ");
			int number = sc.nextInt();
			
			while(number < 0){
				System.out.print("\nInvalid Number, Please Try Again: ");
				number = sc.nextInt();
			}
			
			if(number % 3 == 0 && number % 5 == 0){
				System.out.println("\nCongratulation, You Won A Surprise Gift\n\n");
			}else{
				System.out.println("\nOhh Sorry!, You Missed The Surprise Gift\n\n");
			}
		}
		
		System.out.println("No More Gift Available!, Please Try Again Next Time");
	}
}