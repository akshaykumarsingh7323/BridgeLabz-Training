/*
	17. Online Quiz Application 🧠
	Ask 5 questions (MCQs) from a user.
	● Use arrays and for-loop.
	● Record score.
	● Switch for answer checking. Apply clear indentation and structured layout.
*/

import java.util.*;
class QuizApplicatiom{
    public static void main(String args []){
		Scanner sc = new Scanner(System.in);
		System.out.println("\n-----------------------------------");
		System.out.println("----- Online Quiz Application -----");
		System.out.println("-----------------------------------\n");
		
		System.out.println("Choose Any One Option: ");

		String questions[] = { "1. Who is the founder of Java? \na. James Gosling \nb. Dennis Ritchie \nc. Bjarne Stroustrup \nd. Guido van Rossum",
							   "2. What is the output of System.out.println(10 / 3); in Java? \na. 3.333... \nb. 3  \nc. 10/3 \nd. Compilation Error",
							   "3. What is the entry point for a Java application? \na. start() method \nb. init() method \nc. main() method \nd. execute() method", 
							   "4. Which of the following is a primitive data type in Java? \na. String \nb. Integer \nc. boolean \nd. Array", 
							   "5. What keyword is used to create an object of a class in Java? \na. new \nb. create \nc. instance \nd. this" };
		
		char correctOptions [] = {'a', 'b', 'c', 'c', 'a'};

		char input [] = new char [5];
		
		for(int i = 0; i < questions.length; i++){
			System.out.println("\n\n" + questions[i]);
			System.out.print("\nChoose correct option : ");
			
			char ch = sc.next().toLowerCase().charAt(0);
			
			while(!(ch == 'a' || ch == 'b' || ch == 'c' || ch == 'd')){
				System.out.print("\nPlease enter (a or b or c or d) only!: ");
				ch = sc.next().toLowerCase().charAt(0);
			}
			
			input[i] = ch;
		}
		
		int result = 0;
		
		for(int i = 0; i < input.length; i++){
			char ch = input[i];
			switch(ch){
				case 'a', 'b', 'c', 'd' -> {
					if(correctOptions[i] == ch) result++;
				}
			}
		}
		System.out.println("\nCorrect answer: " + result);
		System.out.println("Incorrect answer: " + (input.length - result));
    }
}