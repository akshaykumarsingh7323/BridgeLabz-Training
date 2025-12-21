import java.util.*;

public class HandshakeExample {

    // Method to calculate number of handshakes

    static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = kb.nextInt();

        int handshakes = calculateHandshakes(numberOfStudents);

        // Display result
        System.out.println("Maximum number of handshakes = " + handshakes);
    }
}
