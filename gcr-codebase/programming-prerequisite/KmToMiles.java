import java.util.*;
class KmToMiles{
   public static void main(String args[]){
       Scanner kb=new Scanner(System.in); 
       System.out.println("Enter distance in KM:");
       double distance=kb.nextInt();
       double miles=distance * 0.621371;
       System.out.println(distance+" KM = "+miles+ " miles");
   }
} 

