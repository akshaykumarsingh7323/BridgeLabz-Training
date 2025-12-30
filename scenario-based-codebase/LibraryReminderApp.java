/*
	15. Rohan’s Library Reminder App 
	Rohan wants a fine calculator:
	● Input return date and due date.
	● If returned late, calculate fine: ₹5/day.
	● Repeat for 5 books using for-loop.
*/

import java.util.*;

// create a class to calculate fine in the library
public class LibraryReminderApp{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int totalFine = 0;

        System.out.println(" Rohan's Library Reminder App\n");

        for(int i = 1; i <= 5; i++){

            System.out.println("Book " + i);

            System.out.print("Enter Due Date (day number): ");
            int dueDate = sc.nextInt();

            System.out.print("Enter Return Date (day number): ");
            int returnDate = sc.nextInt();

            if(returnDate > dueDate){
               int lateDays = returnDate - dueDate;
               int fine = lateDays * 5;
               totalFine += fine;

               System.out.println("Late by " + lateDays + " days");
               System.out.println("Fine for this book: Rs " + fine);
            }else{
                System.out.println("Returned on time. No fine");
            }

            System.out.println("--------------------------------");
        }

        System.out.println("\nTotal Fine for all books: Rs " + totalFine);
        System.out.println("Thank you");
    }
}
