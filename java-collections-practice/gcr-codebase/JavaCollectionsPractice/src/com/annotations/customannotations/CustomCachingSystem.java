package com.annotations.customannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CustomCachingSystem {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface CacheResult {
    }

    static class Calculator {

        @CacheResult
        public int square(int n) {
            System.out.println("Computing square of " + n);
            return n * n;
        }
    }

    static class CacheManager {

        private static final Map<String, Object> cache = new HashMap<>();

        public static Object invoke(Object obj, String methodName, Object... args)
                throws Exception {

            Class<?> clazz = obj.getClass();
            Method method = clazz.getMethod(methodName, int.class);

            String key = methodName + "_" + args[0];

            if (method.isAnnotationPresent(CacheResult.class)) {

                if (cache.containsKey(key)) {
                    System.out.println("Returning cached result for " + key);
                    return cache.get(key);
                }

                Object result = method.invoke(obj, args);

                cache.put(key, result);
                return result;
            }

            return method.invoke(obj, args);
        }
    }

    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();

        System.out.println(CacheManager.invoke(calculator, "square", 5));
        System.out.println(CacheManager.invoke(calculator, "square", 5)); // cached
        System.out.println(CacheManager.invoke(calculator, "square", 10));
        System.out.println(CacheManager.invoke(calculator, "square", 10)); // cached
    }
}

