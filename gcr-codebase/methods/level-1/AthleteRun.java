import java.util.*;

public class AthleteRun {

    static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter first side of the triangle (in meters): ");
        double side1 = kb.nextDouble();

        System.out.print("Enter second side of the triangle (in meters): ");
        double side2 = kb.nextDouble();

        System.out.print("Enter third side of the triangle (in meters): ");
        double side3 = kb.nextDouble();

        double rounds = calculateRounds(side1, side2, side3);

        // Display Output
        System.out.println("Number of rounds required to complete 5 km run = " + rounds);

    }
}
