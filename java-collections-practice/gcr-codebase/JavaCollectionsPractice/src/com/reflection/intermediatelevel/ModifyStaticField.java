package com.reflection.intermediatelevel;

import java.lang.reflect.Field;

public class ModifyStaticField {

    private static String name = "Akshay";

    public static void main(String[] args) throws Exception {

        System.out.println("Before = " + name);

        Class<?> c = ModifyStaticField.class;

        Field f = c.getDeclaredField("name");

        f.setAccessible(true);

        f.set(null, "Aman");

        System.out.println("After  = " + name);
    }
}

