/*
The Number Guessing Game
A game asks the player to guess a number between 1 and 100.
Core Java Scenario Based Problem Statements
Use do-while loop.
Give hints like "Too high" or "Too low".
Count attempts and exit after 5 wrong tries.
*/

import java.util.*;
public class GuessingGame{
    public static void main(String args []){
	Scanner kb = new Scanner(System.in);
	
	int random = (int)(Math.random() * 99) + 1;
	int attempt = 0;
	int start = 0;
	int end = 100;
	do{
	System.out.println("\nAttempts left: " + (5 - attempt));
	System.out.println("Guess the number between " + start + " and " + end);
	int number = kb.nextInt();
	while(number < start || number > end ){
	    System.out.println("Out of range!, Please enter number between " + start + " and " + end + " only");
	    number = kb.nextInt();
        }
	attempt++;
	if(number < random){
	   System.out.println("too low");
	   start = number;
	}else if(number > random){
	   System.out.println("too high");
	   end = number;
	}else{
	   System.out.println("Congratulation, You guessed correct number");
	   return;
	}
	}while(attempt < 5 );
	System.out.println("You didn't guess the number!\nRandom number is: " + random);
    }
}