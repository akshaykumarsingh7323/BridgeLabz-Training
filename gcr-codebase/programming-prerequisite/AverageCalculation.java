import java.util.*;
class AverageCalculation{
   public static void main(String args[]){
       Scanner kb=new Scanner(System.in); 
       System.out.println("Enter first number:");
       double n1=kb.nextDouble();
       System.out.println("Enter second number:");
       double n2=kb.nextDouble();
       System.out.println("Enter third number:");
       double n3=kb.nextDouble();
       double avg=(n1+n2+n3)/3;

       //Displaying output

       System.out.println("Average is: "+avg);
   }
} 
