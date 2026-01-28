package com.birdsanctuary;

public class AnnotationReader {

    public static void printDeveloperInfo(Bird bird) {

        Class<?> clazz = bird.getClass();

        if (clazz.isAnnotationPresent(DeveloperInfo.class)) {
            DeveloperInfo info = clazz.getAnnotation(DeveloperInfo.class);

            System.out.println("Developer: " + info.developer());
            System.out.println("Version: " + info.version());
        }
    }
}

