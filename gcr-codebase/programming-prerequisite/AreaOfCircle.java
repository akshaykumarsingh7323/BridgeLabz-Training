import java.util.*;
class AreaOfCircle{
   public static void main(String args[]){
       Scanner kb=new Scanner(System.in); 
       System.out.println("Enter radius:");
       int radius=kb.nextInt();
       double area=3.14*radius*radius;
       System.out.println("Area of circle is: "+area);
   }
} 

