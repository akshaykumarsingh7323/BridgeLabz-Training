package com.constructor.level1;

public class Circle {
	private double radius;
	
	Circle(){
		this(2.0);
	}
	
	Circle(double radius){
		this.radius = radius;
	}
	
	void display() {
		System.out.println("Radius is: " + radius);
	}
}
