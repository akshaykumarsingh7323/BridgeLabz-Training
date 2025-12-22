import java.util.Scanner;

public class PrintCalendary {

    // Leap year check
    static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Days in month
    static int getDaysInMonth(int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && isLeapYear(year))
            return 29;
        return days[month - 1];
    }

    // First day calculation (Gregorian formula)
    static int getFirstDay(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (d + x + (31 * m0) / 12) % 7;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        String[] months = {
            "January","February","March","April","May","June",
            "July","August","September","October","November","December"
        };

        System.out.println();
        System.out.println("   " + months[month - 1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDay(month, year);
        int days = getDaysInMonth(month, year);

        int day = 1;

        // Week 1
        String line = "";
        for (int i = 0; i < firstDay; i++) {
            line += "    ";
        }
        while (day <= days && line.length() < 28) {
            line += (day < 10 ? "  " + day + " " : " " + day + " ");
            day++;
        }
        System.out.println(line);

        // Remaining weeks
        while (day <= days) {
            line = "";
            for (int i = 0; i < 7 && day <= days; i++) {
                line += (day < 10 ? "  " + day + " " : " " + day + " ");
                day++;
            }
            System.out.println(line);
        }
    }
}