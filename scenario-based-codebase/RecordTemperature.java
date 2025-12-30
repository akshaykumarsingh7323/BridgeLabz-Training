/*
  11.Temperature Logger 
  Record temperatures over 7 days.
  Use array and for-loop.
  Find average and max temperature.
  Use if for comparisons. Maintain readable naming and modular code blocks.
*/

import java.util.*;

// create a class to calculate average and max temperature
public class RecordTemperature{
    public static void main(String args []){
	Scanner sc = new Scanner(System.in);
	double temperature [] = new double [7]; 
	double total = 0;
	double max_temp = 0;
	
	// input temperature from user
	for(int i = 0; i < temperature.length; i++) {
	    System.out.println("Enter temperature of day " + (i+1) + ": ");
	    temperature[i] = sc.nextDouble();
	} 

	// Calculating average and max temperature
	for(int i = 0; i < temperature.length; i++) {
	    total = total + temperature[i];
	    if(temperature[i] > max_temp) max_temp = temperature[i];	    
	}

	// displaying output
	System.out.format("\nAverage Temperature : %.2f\u00B0C", (total / temperature.length));
	System.out.format("\nMaximun Temperature : %.2f\u00B0C", max_temp);
    }
}
