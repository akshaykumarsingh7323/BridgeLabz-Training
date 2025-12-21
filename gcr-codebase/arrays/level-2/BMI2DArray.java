import java.util.Scanner;

// create a program to calculate BMI using 2D array

public class BMI2DArray {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = kb.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            do {
                System.out.print("Enter height (meters): ");
                personData[i][0] = kb.nextDouble();
            } while (personData[i][0] <= 0);

            do {
                System.out.print("Enter weight (kg): ");
                personData[i][1] = kb.nextDouble();
            } while (personData[i][1] <= 0);
        }

        for (int i = 0; i < number; i++) {
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

	// Display the output

        System.out.println("\nBMI REPORT");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height : " + personData[i][0] + " m");
            System.out.println("Weight : " + personData[i][1] + " kg");
            System.out.println("BMI    : " + personData[i][2]);
            System.out.println("Status : " + weightStatus[i]);
        }
    }
}