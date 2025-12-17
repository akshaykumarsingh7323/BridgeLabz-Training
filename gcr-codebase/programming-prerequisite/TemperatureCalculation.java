import java.util.*;
class TemperatureCalculation{
   public static void main(String args[]){
       Scanner kb=new Scanner(System.in); 
       System.out.println("Enter temperature in Celsius:");
       int a=kb.nextInt();
       double fahrenheit=(a * 9/5) + 32	;
       System.out.println(a+" degree Celsius = "+fahrenheit);
   }
} 


