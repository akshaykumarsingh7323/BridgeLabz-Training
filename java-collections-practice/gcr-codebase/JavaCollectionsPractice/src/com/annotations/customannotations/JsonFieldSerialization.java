package com.annotations.customannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

public class JsonFieldSerialization {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface JsonField {
        String name();
    }

    static class User {

        @JsonField(name = "user_name")
        private String username;

        @JsonField(name = "user_age")
        private int age;

        private String password;

        public User(String username, int age, String password) {
            this.username = username;
            this.age = age;
            this.password = password;
        }
    }

    public static String toJson(Object obj) throws Exception {

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder json = new StringBuilder("{");
        boolean first = true;

        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField jf = field.getAnnotation(JsonField.class);

                if (!first) {
                    json.append(", ");
                }

                json.append("\"")
                    .append(jf.name())
                    .append("\": ");

                Object value = field.get(obj);

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                first = false;
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {

        User user = new User("Akshay", 22, "secret123");

        String json = toJson(user);
        System.out.println(json);
    }
}

