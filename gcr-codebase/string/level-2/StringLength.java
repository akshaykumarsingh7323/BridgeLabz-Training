import java.util.*;

// create a class to find the length of string

public class StringLength{

    static int findLength(String text){
        int count = 0;

        try{
            while(true){
                text.charAt(count);
                count++;
            }
        } catch (Exception e){
	    System.out.println("No more index!, You are you trying to access more indexes");
        }

        return count;
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = kb.next(); 
        int userLength = findLength(text);
        int builtInLength = text.length();

        System.out.println("Length using user-defined method: " + userLength);
        System.out.println("Length using built-in length(): " + builtInLength);
    }
}
