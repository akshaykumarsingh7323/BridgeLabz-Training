package com.reflection.intermediatelevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public class CustomAnnotations {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Author {
        String name();
    }

    @Author(name = "Author Name")
    static class Book {
        void read() {
            System.out.println("Reading book...");
        }
    }

    public static void main(String[] args) {

        // Class object
        Class<Book> clazz = Book.class;

        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        }
    }
}
