package com.lambdaexpression.functionalinterface;

import java.util.Scanner;

public class UseSmartHome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DeviceAction device = null;

        while(true) {
	        System.out.println("Select Device:");
	        System.out.println("1. Light");
	        System.out.println("2. AC");
	        System.out.println("3. TV");
        
	        int deviceChoice = sc.nextInt();
	
	        switch (deviceChoice) {
	            case 1:
	                device = new Light();
	                break;
	            case 2:
	                device = new AC();
	                break;
	            case 3:
	                device = new TV();
	                break;
	            default:
	                System.out.println("Invalid Device");
	                return;
	        }
	
	        System.out.println("\nSelect Action:");
	        System.out.println("0. Close All");
	        System.out.println("1. Turn ON");
	        System.out.println("2. Turn OFF");
	
	        int actionChoice = sc.nextInt();
	
	        switch (actionChoice) {
	        	case 0: 
	        		System.out.println("All appliances are closed!");
	        		System.exit(0);
	            case 1:
	                device.turnOn();
	                System.out.println();
	                break;
	            case 2:
	                device.turnOff();
	                System.out.println();
	                break;
	            default:
	                System.out.println("Invalid Action");
	                System.out.println();
	        }
        }
    }
}

