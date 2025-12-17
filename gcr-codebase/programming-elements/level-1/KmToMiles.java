import java.util.Scanner;

// This class converts distance from kilometers to miles It takes input from the user using Scanner. 
public class KmToMiles {

    public static void main(String[] args) {

        // Declare variable to store kilometers and convert to miles
        double km;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        km = input.nextDouble();
        double miles = km / 1.6;

        // Display the result on the screen and close the scanner
        System.out.println("The total miles is " + miles +" mile for the given " + km + " km");
        input.close();
    }
}

