package com.inheritence.animal;

public class Cat extends Animal {
	
	Cat(String name, int age){
		
		super(name, age);
	}
	
	void makeSound() {
        System.out.println(name + " says: Meow Meow");
    }
	
}
