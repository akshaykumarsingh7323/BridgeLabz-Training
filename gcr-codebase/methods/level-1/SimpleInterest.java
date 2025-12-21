import java.util.*;

//Create a class using a method to calculate the simple interest

public class SimpleInterest {

    public static double calculateSimpleInterest(double principal, double rate, double time) {
        double simpleInterest = (principal * rate * time) / 100;
        return simpleInterest;
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        double principal = kb.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = kb.nextDouble();

        System.out.print("Enter Time: ");
        double time = kb.nextDouble();

        double si = calculateSimpleInterest(principal, rate, time);

        // Display Output
        System.out.println("The Simple Interest is " + si +  " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
    }
}
