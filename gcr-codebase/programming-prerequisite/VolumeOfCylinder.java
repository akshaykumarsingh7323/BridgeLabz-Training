import java.util.*;
class VolumeOfCylinder{
   public static void main(String args[]){
       Scanner kb=new Scanner(System.in); 
       System.out.println("Enter radius:");
       int radius=kb.nextInt();
       System.out.println("Enter height:");
       int height=kb.nextInt();
       double volume=3.14*radius*radius*height;
       System.out.println("volume of cylinder is: "+volume);
   }
} 

