import java.util.*;

// create a class SideOfSquare to take input from the user and find side of the square
public class SideOfSquare{
     public static void main(String args []){

	 Scanner kb = new Scanner(System.in);

         // declare a variable perimeter and assign value from user and find side of square

	 System.out.println("Enter perimeter of Square:");
	 int perimeter = kb.nextInt();

	 double side = perimeter / 4.0;  

         //Display the result on the screen
	 System.out.println("The length of the side is "+side+" whose perimeter is "+perimeter);   
     }
}