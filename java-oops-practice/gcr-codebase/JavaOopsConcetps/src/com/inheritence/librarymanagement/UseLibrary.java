package com.inheritence.librarymanagement;

public class UseLibrary {
	public static void main(String[] args) {

        Author a1 = new Author(
                "Java Programming",
                2022,
                "James Gosling",
                "Creator of Java language"
        );

        a1.displayInfo();
    }
}
