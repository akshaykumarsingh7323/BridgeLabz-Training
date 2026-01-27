package com.annotations.customannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class ImportantMethods {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface ImportantMethod {
        String level() default "HIGH";
    }

    static class Service {

        @ImportantMethod
        public void saveData() {
            System.out.println("Saving data...");
        }

        @ImportantMethod(level = "MEDIUM")
        public void loadData() {
            System.out.println("Loading data...");
        }

        public void helperMethod() {
            System.out.println("Helper method");
        }
    }

    public static void main(String[] args) {

        Method[] methods = Service.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(ImportantMethod.class)) {

                ImportantMethod info = method.getAnnotation(ImportantMethod.class);

                System.out.println("Method: " + method.getName() + ", Level: " + info.level());
            }
        }
    }
}

