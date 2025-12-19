import java.util.*;

// create a class Calculator to perform addition, subtraction, division and multiplication

public class Calculator{
   public static void main(String [] args){

      Scanner kb = new Scanner(System.in);

      System.out.println("Enter first number: ");
      double first = kb.nextDouble();

      System.out.println("Enter second number:");
      double second = kb.nextDouble();

      System.out.println("Enter operator (+, -, *, /): ");
      String op = kb.next();

      switch (op){

     case "+":
        System.out.println("Result = " + (first + second));
        break;

     case "-":
        System.out.println("Result = " + (first - second));
        break;

     case "*":
        System.out.println("Result = " + (first * second));
        break;

     case "/":
	if(second != 0){
           System.out.println("Result = " + (first / second));
        }else{
           System.out.println("Cannot divide by zero");
        }
         break;

     default:
           System.out.println("Invalid Operator");
      }

   }
}




