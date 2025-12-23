import java.util.*;

public class NumberFormatDemo{

    static void generateException(String text){
        int num = Integer.parseInt(text);  
        System.out.println("Number is: " + num);
    }

    static void handleException(String text){

        try{
            int num = Integer.parseInt(text);
            System.out.println("Number is: " + num);

        }catch (NumberFormatException e){
            System.out.println("NumberFormatException handled");
        }catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter a value:");
        String text = kb.next();

        System.out.println("\nGenerating Exception:");
        try{
            generateException(text);
        }catch (NumberFormatException e){
            System.out.println("Exception occurred in generateException()");
        }

        System.out.println("\nHandling Exception:");
        handleException(text);
    }
}
