import java.util.Scanner;
public class CheckPalindrome{

    private static String takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        return sc.nextLine();
    }

    private static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static void displayResult(String str, boolean result) {
        if(result) {
            System.out.println("\"" + str + "\" is a PALINDROME");
        } else {
            System.out.println("\"" + str + "\" is NOT a palindrome");
        }
    }

    public static void main(String[] args) {
        String input = takeInput();
        boolean result = isPalindrome(input);
        displayResult(input, result);
    }
}