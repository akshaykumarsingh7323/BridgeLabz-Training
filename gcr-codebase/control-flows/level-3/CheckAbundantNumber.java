import java.util.*;

// create a program to check a number is Abundant Number

public class CheckAbundantNumber{
    public static void main(String [] args){

       Scanner kb=new Scanner(System.in);

       // taking input from the user and assign to variable number
      
       System.out.println("Enter a number:");
 
       int number=kb.nextInt();

       int sum = 0;

       for(int i = 1; i < number; i++){
          if(number % i == 0){
             sum = sum + i;
          }
       }

       if(sum > number){
          System.out.println(number + " is an Abundant Number");
       }else{
          System.out.println(number + " is Not an Abundant Number");
       }
       kb.close();
    }
}

 
