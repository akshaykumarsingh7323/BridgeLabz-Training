package com.reflection.basiclevel;

class Student {

    private String name;
    private int rollNo;

    public Student() {
        this.name = "Default";
        this.rollNo = 0;
    }

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void display() {
        System.out.println("Name   : " + name);
        System.out.println("RollNo : " + rollNo);
    }
}


public class DynamicallyCreateObject {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.reflection.basiclevel.Student");

        Object obj = clazz.getDeclaredConstructor().newInstance();

        Student student = (Student) obj;

        student.display();
    }
}

