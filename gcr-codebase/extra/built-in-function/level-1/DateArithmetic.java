// Create a program that takes a date input and adds 7 days, 1 month, and 2 years to it. then subtracts 3 weeks from the result

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDate = sc.nextLine();

        LocalDate date = LocalDate.parse(inputDate, formatter);
        System.out.println("Original Date: " + date.format(formatter));

        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2);
        System.out.println("After adding 7 days, 1 month, 2 years: " + updatedDate.format(formatter));

        LocalDate finalDate = updatedDate.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + finalDate.format(formatter));
    }
}
