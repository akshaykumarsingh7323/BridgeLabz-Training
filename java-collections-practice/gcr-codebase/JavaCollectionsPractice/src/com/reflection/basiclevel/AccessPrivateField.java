package com.reflection.basiclevel;

import java.lang.reflect.Field;

class Person {
    private int age = 20;
}


public class AccessPrivateField {
    public static void main(String[] args) throws Exception {

        Person person = new Person();

        Class<?> personClass = person.getClass();

        Field ageField = personClass.getDeclaredField("age");

        ageField.setAccessible(true);

        int ageValue = (int) ageField.get(person);
        System.out.println("Age before modification: " + ageValue);

        ageField.set(person, 30);

        int updatedAge = (int) ageField.get(person);
        System.out.println("Age after modification: " + updatedAge);
    }
}
