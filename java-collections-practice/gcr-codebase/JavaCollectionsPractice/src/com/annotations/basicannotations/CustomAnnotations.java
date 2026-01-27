package com.annotations.basicannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class CustomAnnotations {

    @Retention(RetentionPolicy.RUNTIME)
    @interface TaskInfo {
        String priority();
        String assignedTo();
    }

    static class TaskManager {

        @TaskInfo(priority = "High", assignedTo = "Akshay")
        void completeTask() {
            System.out.println("Task completed");
        }
    }

    public static void main(String[] args) throws Exception {

        TaskManager manager = new TaskManager();

        Class<?> clazz = manager.getClass();

        Method method = clazz.getDeclaredMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {

            TaskInfo info = method.getAnnotation(TaskInfo.class);

            System.out.println("Priority   : " + info.priority());
            System.out.println("Assigned To: " + info.assignedTo());
        }
    }
}

