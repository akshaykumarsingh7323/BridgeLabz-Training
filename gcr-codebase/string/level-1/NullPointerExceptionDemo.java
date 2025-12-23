public class NullPointerExceptionDemo{

    static void generateException(){
        String text = null;          
        System.out.println(text.length()); 
    }

    static void handleException(){
        String text = null;

        try{
           System.out.println(text.length());
        }catch (NullPointerException e){
           System.out.println("NullPointerException handled");
        }
    }

    public static void main(String[] args){

        System.out.println("Generating Exception:");
        try{
           generateException();
        }catch(NullPointerException e){
           System.out.println("Exception occurred in generateException()");
        }

        System.out.println("\nHandling Exception:");
        handleException();
    }
}
