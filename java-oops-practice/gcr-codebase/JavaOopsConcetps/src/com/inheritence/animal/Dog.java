package com.inheritence.animal;

public class Dog extends Animal {
	
	Dog(String name, int age){
		super(name, age);
	}
	
	void makeSound() {
		super.makeSound();
		System.out.println(name + " says: woof woof");
	}
}
