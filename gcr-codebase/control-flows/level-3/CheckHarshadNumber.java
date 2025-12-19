import java.util.*;

// create a class to check Harshad Number

public class CheckHarshadNumber{
   public static void main(String[] args){

      // Take input from user
      Scanner kb=new Scanner(System.in);

      System.out.println("Enter a number:");

      int number=kb.nextInt();

      int temp=number;

      int sum=0;

      while(temp>0){
         int digit = temp % 10;
 
         sum = sum + digit;

         temp = temp / 10;
     }
     if(number % sum == 0){
        System.out.println(number + " is  a Harshad Number");
     }else{
        System.out.println(number + " is Not  a Harshad Number");
     }
      kb.close();
   }
}


  
 
 
 