import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame{

    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    public static int generateGuess(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static char getUserFeedback() {
        System.out.print("Enter feedback (H = High, L = Low, C = Correct): ");
        return sc.next().toUpperCase().charAt(0);
    }

    public static void updateRange(char feedback, int guess, int[] range) {
        if(feedback == 'H') {
            range[1] = guess - 1;
        } else if(feedback == 'L') {
            range[0] = guess + 1;
        }
    }

    public static void main(String[] args){
        int min = 1;
        int max = 100;
        int attempts = 0;
        char feedback;

        System.out.println("Think of a number between 1 and 100.");
        while(true){
            int guess = generateGuess(min, max);
            attempts++;

            System.out.println("\nComputer Guess: " + guess);
            feedback = getUserFeedback();

            if(feedback == 'C'){
                System.out.println("Computer guessed your number in " + attempts + " attempts!");
                break;
            } 
            else if(feedback == 'H'){
                max = guess - 1;
            } 
            else if (feedback == 'L'){
                min = guess + 1;
            } 
            else{
                System.out.println("Invalid input! Please enter H, L, or C.");
            }
        }
    }
}