import java.util.*;

public class UnitConvertor3 {

    public static double convertFarhenheitToCelsius(double farhenheit) {
        double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
        return farhenheit2celsius;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsius2farhenheit = (celsius * 9 / 5) + 32;
        return celsius2farhenheit;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double f = kb.nextDouble();
        System.out.println("Fahrenheit to Celsius = " + convertFarhenheitToCelsius(f));

        System.out.print("Enter temperature in Celsius: ");
        double c = kb.nextDouble();
        System.out.println("Celsius to Fahrenheit = " + convertCelsiusToFarhenheit(c));

        System.out.print("Enter weight in pounds: ");
        double pounds = kb.nextDouble();
        System.out.println("Pounds to Kilograms = " + convertPoundsToKilograms(pounds));

        System.out.print("Enter weight in kilograms: ");
        double kg = kb.nextDouble();
        System.out.println("Kilograms to Pounds = " + convertKilogramsToPounds(kg));

        System.out.print("Enter volume in gallons: ");
        double gallons = kb.nextDouble();
        System.out.println("Gallons to Liters = " + convertGallonsToLiters(gallons));

        System.out.print("Enter volume in liters: ");
        double liters = kb.nextDouble();
        System.out.println("Liters to Gallons = " + convertLitersToGallons(liters));
    }
}
