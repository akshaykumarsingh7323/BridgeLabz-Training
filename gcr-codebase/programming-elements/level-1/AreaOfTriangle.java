import java.util.Scanner;

// create a class AraeOfTriangle to find area . 
public class AreaOfTriangle {

    public static void main(String[] args) {

        //declare variable and taking two number in inches
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base (in inches): ");
        double base = input.nextDouble();

        System.out.print("Enter height (in inches): ");
        double height = input.nextDouble();
        
	double arInSqureInches = 0.5 * base * height;
        double arInSqureCentimeters = arInSqureInches * 6.4516 ;
        
        
        // Display the result on screen
        System.out.println("Area of triangle in SquareInches: "+arInSqureInches);
	System.out.println("Area of triangle in SquareCentimeters: "+arInSqureCentimeters);

    }
}
