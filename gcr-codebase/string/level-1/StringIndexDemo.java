import java.util.*;

public class StringIndexDemo {

    static void generateException(String text) {
        System.out.println(text.charAt(text.length()));
    }

    static void handleException(String text){

        try{
           System.out.println(text.charAt(text.length()));
        }catch (StringIndexOutOfBoundsException e) {
           System.out.println("StringIndexOutOfBoundsException handled");
        }
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = kb.next();

        System.out.println("\nGenerating Exception:");
        try{
            generateException(text);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Exception occurred in generateException()");
        }

        System.out.println("\nHandling Exception:");
        handleException(text);
    }
}
