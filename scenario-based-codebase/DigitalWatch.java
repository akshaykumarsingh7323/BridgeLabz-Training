/*
	16. Digital Watch Simulation ⏱️
	Simulate a 24-hour watch:
	● Print hours and minutes in a nested for-loop.
	● Use a break to stop at 13:00 manually (simulate power cut).`
	Core Java Scenario Based Problem Statements
*/

import java.util.*;
public class DigitalWatch{
    public static void main(String args []){
		System.out.println("\n-----------------------------------------------");
	    System.out.println("----------- Digital Watch Simulator -----------");
		System.out.println("-----------------------------------------------\n");
	    for(int i = 0; i < 24; i++){

			if(i == 13) {
				System.out.println("\n-------------------------------------");
				System.out.println("It's 13:00 O'clock and Power cut-off!"); 
				System.out.println("-------------------------------------");
				break;
			}

			System.out.println("\n---------------");

			if(i == 0) System.out.println("It's " + "12"  + " O'clock");
			else if(i < 10) System.out.println("It's " + "0" + i + " O'clock");
			else  System.out.println("It's "  + i + " O'clock");

			System.out.println("---------------\n");

			for(int j = 0; j < 60; j++){

                if(i < 10 && j < 10) System.out.println("0" + i + " : 0"+ j);
				else if(i < 10) System.out.println("0" + i + " : "+ j);
				else if(j < 10) System.out.println(i + " : 0"+ j);
				else System.out.println(i + " : "+ j);

			}
		}
	}
}