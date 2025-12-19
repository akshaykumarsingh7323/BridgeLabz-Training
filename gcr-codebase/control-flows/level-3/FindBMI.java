import java.util.*;

// create a program to find BMI

public class FindBMI{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	// Get input from the user

	System.out.println("Enter weight(in kg):");
	double weight = kb.nextDouble();

	System.out.println("Enter weight(in cm):");
	double height = kb.nextDouble(); 

	height = height / 100;   //convert cm to meter

	double BMI = weight / (height * height); 
	  
	if(BMI < 18.4){
	    System.out.println("Underweight");
	}else if(BMI >= 18.5 && BMI <= 24.9){
	    System.out.println("Normal");
	}else if(BMI >= 25.0 && BMI <= 39.9){
	    System.out.println("Overweight");
        }else if(BMI >= 40.0){
	    System.out.println("Obense");
	}
    }
}