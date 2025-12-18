import java.util.Scanner;

// create a class Calculaor to add, subtract, multiply and division. 
public class Calculator {

    public static void main(String[] args) {

        //declare variable and taking two number from the user and performing operations 
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter first number: ");
        double number2 = input.nextDouble();

        double addition = number1 + number2;

	double subtraction = number1 - number2;

	double multiplication = number1 * number2;

	double division = number1 / number2;

        // Display the result on screen
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+number1+" and "+number2+" is "+addition+" , "+subtraction+" , "+multiplication+" ,  and "+division);
    }
}