package com.reflection.advancedlevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class DependencyInjection {

    @Retention(RetentionPolicy.RUNTIME)
    @interface Inject {
    }

    static class Service {
        void serve() {
            System.out.println("Service is working...");
        }
    }

    static class Client {

        @Inject
        private Service service;

        void doWork() {
            service.serve();
        }
    }

    static class DIContainer {

        public static <T> T createObject(Class<T> clazz) throws Exception {

            T obj = clazz.getDeclaredConstructor().newInstance();

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {

                if (field.isAnnotationPresent(Inject.class)) {

                    Object dependency =
                            field.getType().getDeclaredConstructor().newInstance();

                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }
            return obj;
        }
    }

    public static void main(String[] args) throws Exception {

        Client client = DIContainer.createObject(Client.class);
        client.doWork();
    }
}

