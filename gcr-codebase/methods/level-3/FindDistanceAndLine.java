import java.util.*;

// Write a program for Euclidean distance between two points as well as the equation of the line using those two points

public class FindDistanceAndLine{

    static double toFindDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    static double[] toFindLineEquation(int x1, int y1, int x2, int y2){
        double m = (double)(y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[]{m, b};
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        int x1 = kb.nextInt();
        int y1 = kb.nextInt();

        System.out.print("Enter x2 y2: ");
        int x2 = kb.nextInt();
        int y2 = kb.nextInt();

        double distance = toFindDistance(x1, y1, x2, y2);
        double[] line = toFindLineEquation(x1, y1, x2, y2);

	System.out.println();
        System.out.println("Euclidean Distance = " + distance);
        System.out.println("Equation of Line: y = " + line[0] + " x + " + line[1]);
    }
}