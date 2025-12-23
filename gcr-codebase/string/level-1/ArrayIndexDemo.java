import java.util.*;

public class ArrayIndexDemo{

    static void generateException(String[] names){
        System.out.println(names[names.length]);
    }

    static void handleException(String[] names){

        try{
            System.out.println(names[names.length]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException handled");
        }catch (RuntimeException e){
            System.out.println("RuntimeException handled");
        }
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter number of names:");
        int n = kb.nextInt();

        String[] names = new String[n];

        System.out.println("Enter names:");
        for(int i = 0; i < n; i++){
            names[i] = kb.next();
        }

        System.out.println("\nGenerating Exception:");
        try{
            generateException(names);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception occurred in generateException()");
        }

        System.out.println("\nHandling Exception:");
        handleException(names);
    }
}
