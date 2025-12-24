// Write a program that takes two date inputs and compares them to check if the first date is before, after, or the same as the second date

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparison{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter the first date (yyyy-MM-dd): ");
        String date1Str = sc.nextLine();
        LocalDate date1 = LocalDate.parse(date1Str, formatter);

        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String date2Str = sc.nextLine();
        LocalDate date2 = LocalDate.parse(date2Str, formatter);

        if(date1.isBefore(date2)){
            System.out.println(date1 + " is before " + date2);
        }else if (date1.isAfter(date2)){
            System.out.println(date1 + " is after " + date2);
        }else if (date1.isEqual(date2)){
            System.out.println(date1 + " is the same as " + date2);
        }
    }
}
