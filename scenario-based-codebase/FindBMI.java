import java.util.*;

// create a class to find BMI of a person

public class FindBMI{
    public static void main(String args []){

	Scanner sc =  new Scanner(System.in);

	// Get input from the user

        System.out.println("Enter height(in cm):");
	double height = sc.nextInt();
	height = height / 100;
	
	System.out.println("Enter weigth:");
	double weight = sc.nextInt();
	
	double bmi = weight / (height * height);

	if (bmi <= 18.4) {
           System.out.println("Status: Underweight");
        } else if (bmi <= 24.9) {
           System.out.println("Status: Normal");
        } else if (bmi <= 39.9) {
           System.out.println("Status: Overweight");
        } else {
           System.out.println("Status: Obese");
        }
    }	
}