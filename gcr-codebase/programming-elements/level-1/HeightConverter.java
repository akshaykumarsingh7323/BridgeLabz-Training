import java.util.Scanner;

// This class converts height from centimeters to feet and inches.
public class HeightConverter {

    public static void main(String[] args) {

        //declare variable and taking input from user in centimeter and convert into feet and inches
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();
        double totalInches = heightCm / 2.54;
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;

        // Display the result on screen
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + inches);
    }
}