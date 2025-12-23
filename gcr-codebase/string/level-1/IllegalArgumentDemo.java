import java.util.*;

public class IllegalArgumentDemo{

    static void generateException(String text, int start, int end){

        if(start > end){
           throw new IllegalArgumentException("Start index is greater than end index");
        }

        System.out.println(text.substring(start, end));
    }

    static void handleException(String text, int start, int end){

        try{
            if (start > end){
                throw new IllegalArgumentException("Start index is greater than end index");
            }

            System.out.println(text.substring(start, end));

        }catch (IllegalArgumentException e){
           System.out.println("IllegalArgumentException handled");
        }catch (RuntimeException e){
           System.out.println("RuntimeException handled");
        }
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = kb.next();

        System.out.println("Enter start index:");
        int start = kb.nextInt();

        System.out.println("Enter end index:");
        int end = kb.nextInt();

        System.out.println("\nGenerating Exception:");
        try{
            generateException(text, start, end);
        }catch (IllegalArgumentException e){
            System.out.println("Exception occurred in generateException()");
        }

        System.out.println("\nHandling Exception:");
        handleException(text, start, end);
    }
}
