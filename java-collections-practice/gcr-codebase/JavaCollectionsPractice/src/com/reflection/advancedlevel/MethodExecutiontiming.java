package com.reflection.advancedlevel;

import java.lang.reflect.Method;

public class MethodExecutiontiming {

    static class Task {

        public void fastTask() {
            for (int i = 0; i < 1000; i++);
        }

        public void slowTask() {
            for (int i = 0; i < 1000000; i++);
        }
    }

    public static void measureExecutionTime(Object obj) throws Exception {

        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            long startTime = System.nanoTime();

            method.invoke(obj);   

            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println(method.getName() + " executed in " + duration + " ns");
        }
    }

    public static void main(String[] args) throws Exception {

        Task task = new Task();
        measureExecutionTime(task);
    }
}
