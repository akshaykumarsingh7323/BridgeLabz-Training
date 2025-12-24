import java.util.*;
public class ConvertTemperature{

    public static double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius){
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");

        System.out.print("Choose an option (1 or 2) : ");
        int choice = sc.nextInt();

        if(choice == 1){
            System.out.print("Enter temperature in Fahrenheit : ");
            double f = sc.nextDouble();
            double c = fahrenheitToCelsius(f);
            System.out.println("Temperature in Celsius : " + c);
        }
        else if(choice == 2) {
            System.out.print("Enter temperature in Celsius : ");
            double c = sc.nextDouble();
            double f = celsiusToFahrenheit(c);
            System.out.println("Temperature in Fahrenheit : " + f);
        }
        else{
            System.out.println("Invalid choice!");
        }
    }
}