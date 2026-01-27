package com.annotations.customannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class RoleBasedAccess {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface RoleAllowed {
        String value();
    }

    @RoleAllowed("ADMIN")
    static class AdminService {

        public void deleteUser() {
            System.out.println("User deleted successfully");
        }
    }

    public static void invokeIfAllowed(Object obj, String userRole)
            throws Exception {

        Class<?> clazz = obj.getClass();

        if (clazz.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);

            if (!roleAllowed.value().equals(userRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }

        for (Method method : clazz.getDeclaredMethods()) {
            method.invoke(obj);
        }
    }

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();

        System.out.println("User Role: USER");
        invokeIfAllowed(service, "USER");   

        System.out.println("\nUser Role: ADMIN");
        invokeIfAllowed(service, "ADMIN");
    }
}
