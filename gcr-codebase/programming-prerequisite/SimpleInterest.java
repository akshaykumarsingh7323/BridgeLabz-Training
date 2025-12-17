import java.util.*;
class SimpleInterest{
   public static void main(String args[]){
       Scanner kb=new Scanner(System.in); 
       System.out.println("Enter principal:");
       int p=kb.nextInt();
       System.out.println("Enter rate:");
       int r=kb.nextInt();
       System.out.println("Enter time:");
       int t=kb.nextInt();
       double si=(p*r*t)/100;
       System.out.println("Simple interest is: "+si);
   }
} 

