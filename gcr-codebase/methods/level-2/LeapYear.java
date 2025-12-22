import java.util.*;

public class LeapYear {

    public static boolean isLeapYear(int year) {

        if (year < 1582) {
            return false;
        }

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = kb.nextInt();

        boolean result = isLeapYear(year);

        // Disply Output
        if (result) {
            System.out.println("Year is a Leap Year");
        } else {
            System.out.println("Year is not a Leap Year");
        }
    }
}
