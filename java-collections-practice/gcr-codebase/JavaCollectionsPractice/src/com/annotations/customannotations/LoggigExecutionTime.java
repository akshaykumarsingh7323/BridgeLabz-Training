package com.annotations.customannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class LoggigExecutionTime {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface LogExecutionTime {
    }

    static class TaskService {

        @LogExecutionTime
        public void fastTask() {
            for (int i = 0; i < 1000; i++);
        }

        @LogExecutionTime
        public void slowTask() {
            for (int i = 0; i < 1_000_000; i++);
        }

        public void helperTask() {
            System.out.println("Helper task (not measured)");
        }
    }

    public static void executeWithTiming(Object obj) throws Exception {

        Method[] methods = obj.getClass().getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();

                method.invoke(obj);   

                long end = System.nanoTime();

                System.out.println(
                    method.getName() + " executed in " + (end - start) + " ns"
                );
            }
        }
    }

    public static void main(String[] args) throws Exception {

        TaskService service = new TaskService();
        executeWithTiming(service);
    }
}

