package com.reflection.advancedlevel;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CustomObjectMapper {

    static class Student {
        private int id;
        private String name;
        private int age;

        void display() {
            System.out.println(id + " " + name + " " + age);
        }
    }

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties)
            throws Exception {

        T obj = clazz.getDeclaredConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();

            if (properties.containsKey(fieldName)) {
                field.setAccessible(true);   // private access
                field.set(obj, properties.get(fieldName));
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("id", 101);
        map.put("name", "Akshay");
        map.put("age", 22);

        Student student = toObject(Student.class, map);
        student.display();
    }
}

