import java.util.*;

// create a class to find 3 collinear point using slope and formulae and compare them

public class FindCollinearPoints{

    static boolean isCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3){
        if ((x2 - x1) == 0 || (x3 - x2) == 0 || (x3 - x1) == 0)
            return false;

        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        double slopeAC = (double)(y3 - y1) / (x3 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    static boolean isCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3){
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        int x1 = kb.nextInt();
        int y1 = kb.nextInt();

        System.out.print("Enter x2 y2: ");
        int x2 = kb.nextInt();
        int y2 = kb.nextInt();

        System.out.print("Enter x3 y3: ");
        int x3 = kb.nextInt();
        int y3 = kb.nextInt(); 

	// Display output

        System.out.println("Using Slope Formula: " + isCollinearBySlope(x1, y1, x2, y2, x3, y3));

        System.out.println("Using Area Formula: " + isCollinearByArea(x1, y1, x2, y2, x3, y3));
    }
}