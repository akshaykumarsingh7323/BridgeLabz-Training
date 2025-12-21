import java.util.*;

public class TrigonometricCalculator {

    public static double[] calculateTrigonometricFunctions(double angle) {

        // Convert degrees to radians
        double radians = Math.toRadians(angle);

        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);

        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter angle in degrees: ");
        double angle = kb.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);

        // Display Output
        System.out.println("Sine = " + result[0]);
        System.out.println("Cosine = " + result[1]);
        System.out.println("Tangent = " + result[2]);
    }
}
