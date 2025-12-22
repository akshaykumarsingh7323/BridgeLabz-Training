

import java.util.*
public class UnitConvertor {

    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter kilometers: ");
        double km = kb.nextDouble();
        System.out.println("Kilometers to Miles = " + convertKmToMiles(km));

        System.out.print("Enter miles: ");
        double miles = kb.nextDouble();
        System.out.println("Miles to Kilometers = " + convertMilesToKm(miles));

        System.out.print("Enter meters: ");
        double meters = kb.nextDouble();
        System.out.println("Meters to Feet = " + convertMetersToFeet(meters));

        System.out.print("Enter feet: ");
        double feet = kb.nextDouble();
        System.out.println("Feet to Meters = " + convertFeetToMeters(feet));
    }
}
