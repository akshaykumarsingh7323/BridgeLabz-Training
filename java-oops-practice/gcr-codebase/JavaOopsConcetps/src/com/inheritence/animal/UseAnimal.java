package com.inheritence.animal;

public class UseAnimal {

	public static void main(String[] args) {
		
		Animal a1 = new Dog("Buddy", 3);
		Animal a2 = new Cat("Whispers", 3);
		Animal a3 = new Bird("Tweety", 3);
		
		a1.makeSound();
		a2.makeSound();
		a3.makeSound();
		
	}

}
