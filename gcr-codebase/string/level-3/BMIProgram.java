import java.util.*;

public class BMIProgram{

    public static String[][] calculateBMI(double[][] data){
        String[][] result = new String[10][4];

        for(int i = 0; i < 10; i++){
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100;

            double bmi = weight / (heightM * heightM);
            String status;

            if(bmi < 18.5)
               status = "Underweight";
            else if(bmi < 25)
               status = "Normal";
            else if(bmi < 40)
               status = "Overweight";
            else
               status = "Obese";

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        return result;
    }

    public static void display(String[][] result){
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < 10; i++){
            System.out.println(result[i][0] + "\t\t" +
                               result[i][1] + "\t\t" +
                               result[i][2] + "\t" +
                               result[i][3]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];

        for(int i = 0; i < 10; i++){
            System.out.println("\nEnter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = calculateBMI(data);
        display(result);
    }
}