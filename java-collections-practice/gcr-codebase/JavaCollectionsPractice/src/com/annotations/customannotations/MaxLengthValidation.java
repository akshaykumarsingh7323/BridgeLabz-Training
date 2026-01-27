package com.annotations.customannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

public class MaxLengthValidation {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface MaxLength {
        int value();
    }

    static class User {

        @MaxLength(8)
        private String username;

        public User(String username) {

            validate(username);
            this.username = username;
        }

        private void validate(String username) {
            try {
                Field field = this.getClass().getDeclaredField("username");
                MaxLength max = field.getAnnotation(MaxLength.class);

                if (max != null && username.length() > max.value()) {
                    throw new IllegalArgumentException("Username length must be <= " + max.value());
                }

            } catch (NoSuchFieldException e) {
                throw new RuntimeException("Validation failed", e);
            }
        }

        public void display() {
            System.out.println("Username: " + username);
        }
    }

    public static void main(String[] args) {

        try {
            User u1 = new User("Akshay");  
            u1.display();

            User u2 = new User("VeryLongUsername"); 
            u2.display();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
