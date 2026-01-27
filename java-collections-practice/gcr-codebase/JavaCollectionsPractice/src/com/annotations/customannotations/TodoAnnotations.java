package com.annotations.customannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class TodoAnnotations {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Todo {
        String task();
        String assignedTo();
        String priority() default "MEDIUM";
    }

    static class ProjectService {

        @Todo(
            task = "Implement login feature",
            assignedTo = "Akshay",
            priority = "HIGH"
        )
        public void login() {
        }

        @Todo(
            task = "Add payment gateway",
            assignedTo = "Rahul"
        )
        public void payment() {
        }

        @Todo(
            task = "Improve UI design",
            assignedTo = "Neha",
            priority = "LOW"
        )
        public void uiUpdate() {
        }
    }

    public static void main(String[] args) {

        Method[] methods = ProjectService.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Todo.class)) {

                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method     : " + method.getName());
                System.out.println("Task       : " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority   : " + todo.priority());
                System.out.println("----------------------------");
            }
        }
    }
}
