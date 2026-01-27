package com.reflection.advancedlevel;

import java.lang.reflect.Field;

public class GenerateJSONRepresentation {

    static class Student {
        private int id = 1;
        private String name = "Akshay";
        private int age = 22;
    }

    public static String toJson(Object obj) throws Exception {

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);

            sb.append("\"").append(f.getName()).append("\": ");

            Object value = f.get(obj);

            if (value instanceof String) {
                sb.append("\"").append(value).append("\"");
            } else {
                sb.append(value);
            }

            if (i < fields.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {

        Student student = new Student();
        System.out.println(toJson(student));
    }
}

