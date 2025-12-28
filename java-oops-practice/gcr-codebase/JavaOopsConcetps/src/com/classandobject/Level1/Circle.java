package com.classandobject.Level1;

public class Circle {
	
	double radius;
	
	Circle(double radius){
		this.radius=radius;
	}
	
	public void areaCircle() {
		System.out.println("Area of Circle: " + Math.PI * radius * radius);
	}
	
	public void circumferenceCircle() {
		System.out.println("Circumference of Circle: " + (2 * Math.PI * radius));
	}
	
	public static void main(String[] args) {
		Circle circle = new Circle(10.5);
		circle.areaCircle();
		circle.circumferenceCircle();
	}
}
