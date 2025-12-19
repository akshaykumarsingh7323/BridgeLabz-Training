import java.util.*;

// create a class to count digits

public class CountDigits{
    public static void main (String[] args){

       Scanner kb=new Scanner(System.in);

       // Get input from user and count digits

       System.out.println("Enter an integer:");
       int number=kb.nextInt();
    
       int count=0;

       if(number==0){
         count=1;
       }else{
          while(number!=0){       
          number=number/10;
          count++;
          }
       }

     // Display the count
     System.out.println("Number of digits = " + count);

     kb.close();
   }
}

     

