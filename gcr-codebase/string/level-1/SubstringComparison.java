import java.util.*;

public class SubstringComparison{

    public static String createSubstringUsingCharAt(String text, int start, int end){
        String result = "";
        for(int i = start; i < end; i++){
            result = result + text.charAt(i);
        }
        return result;
    }

    public static boolean compareStringsUsingCharAt(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        for(int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter the string:");
        String text = kb.next();

        System.out.println("Enter start index:");
        int start = kb.nextInt();

        System.out.println("Enter end index:");
        int end = kb.nextInt();

        String subUsingCharAt = createSubstringUsingCharAt(text, start, end);

        String subUsingBuiltIn = text.substring(start, end);

        boolean isSame = compareStringsUsingCharAt(subUsingCharAt, subUsingBuiltIn);

        System.out.println("Substring using charAt(): " + subUsingCharAt);
        System.out.println("Substring using built-in method: " + subUsingBuiltIn);
        System.out.println("Are both substrings same? " + isSame);
    }
}
