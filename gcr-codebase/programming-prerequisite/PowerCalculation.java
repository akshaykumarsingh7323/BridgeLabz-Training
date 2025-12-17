import java.util.*;
class PowerCalculation{
   public static void main(String args[]){
       Scanner kb=new Scanner(System.in); 
       System.out.println("Enter base:");
       double base=kb.nextDouble();
       System.out.println("Enter exponent:");
       double exponent=kb.nextDouble();
       double value=Math.pow(base, exponent);

       //Displaying output

       System.out.println("Result: "+value);
   }
} 

