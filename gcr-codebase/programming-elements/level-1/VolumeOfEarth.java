//create a program to compute the volume of the Earth
public class VolumeOfEarth{
    public static void main(String args []){

         //Variable declare and initialize with radius of earth and calculating volume in cubic kilometer and cubic miled
         int radius = 6378;
         double volumeInCubicKm = (4/3) * Math.PI * Math.pow(radius, 3);
	 double volumeInCubicMiles = volumeInCubicKm * 0.239912;

         // Displaying the result on the screen
         System.out.println("The volume of earth in cubic kilometers is " + volumeInCubicKm + " and cubic miles is "+ volumeInCubicMiles );
    }
}


