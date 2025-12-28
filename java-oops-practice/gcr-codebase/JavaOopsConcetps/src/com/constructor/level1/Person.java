package com.constructor.level1;

public class Person {
	private String name;
	private int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	Person(Person p){
		this.name = p.name;
		this.age = p.age;
	}
	
	void display() {
		System.out.println("Name: " + name + ", " + "Age: " + age);
	}
}
