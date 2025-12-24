import java.util.Scanner;
public class FindFibonacci {
	
    public static void printFibonacci(int terms){
        if(terms <= 0) {
            System.out.println("Please enter a positive number");
            return;
        }

        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence : ");
        for(int i = 1; i <= terms; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms : ");
        int terms = sc.nextInt();

        printFibonacci(terms);
    }
}