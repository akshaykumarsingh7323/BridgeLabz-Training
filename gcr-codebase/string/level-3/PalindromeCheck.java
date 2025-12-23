// Write a program to to check if a text is palindrome and display the result

import java.util.*;

class PalindromeCheck{

    public static boolean isPalindromeLogic1(String text){
        int start = 0;
        int end = text.length() - 1;

        while(start < end){
            if(text.charAt(start) != text.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeLogic2(String text, int start, int end){

        if (start >= end) {
            return true;
        }

        if(text.charAt(start) != text.charAt(end)){
            return false;
        }

        return isPalindromeLogic2(text, start + 1, end - 1);
    }

    public static char[] reverseString(String text){
        char[] reverse = new char[text.length()];
        int index = 0;

        for(int i = text.length() - 1; i >= 0; i--){
            reverse[index] = text.charAt(i);
            index++;
        }
        return reverse;
    }

    public static boolean isPalindromeLogic3(String text){

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++){
            if(original[i] != reverse[i]){
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.next();

        System.out.println("Palindrome using Logic 1: " + isPalindromeLogic1(text));

        System.out.println("Palindrome using Logic 2: " + isPalindromeLogic2(text, 0, text.length() - 1));

        System.out.println("Palindrome using Logic 3: " + isPalindromeLogic3(text));
    }
}
