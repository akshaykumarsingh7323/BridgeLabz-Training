import java.util.*;

public class BMIProgram {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for person " + (i + 1));

            System.out.println("Enter weight in kg:");
            data[i][0] = kb.nextDouble();

            System.out.println("Enter height in cm:");
            data[i][1] = kb.nextDouble();

            double heightMeter = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightMeter * heightMeter);
        }

        System.out.println("BMI STATUS");

        for(int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("BMI: " + data[i][2]);

            if (data[i][2] <= 18.4) {
                System.out.println("Status: Underweight");
            } else if (data[i][2] <= 24.9) {
                System.out.println("Status: Normal");
            } else if (data[i][2] <= 39.9) {
                System.out.println("Status: Overweight");
            } else {
                System.out.println("Status: Obese");
            }
            System.out.println("-----------------------------");
        }
    }
}