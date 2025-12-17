import java.util.*;
class PerimeterOfRectangle{
   public static void main(String args[]){
       Scanner kb=new Scanner(System.in); 
       System.out.println("Enter length:");
       int length=kb.nextInt();
       System.out.println("Enter breadth:");
       int breadth=kb.nextInt();
       double perimeter=2 * (length + breadth);

       //Displaying output

       System.out.println("Perimeter of Rectangle is: "+perimeter);
   }
} 




