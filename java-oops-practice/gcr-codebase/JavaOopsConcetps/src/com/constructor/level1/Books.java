package com.constructor.level1;

public class Books {

    public String ISBN;
    protected String title;
    private String author;

    Books(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    void displayBook() {
        System.out.println(
            "ISBN: " + ISBN +
            ", Title: " + title +
            ", Author: " + author
        );
    }
}


class EBook extends Books {

    String fileFormat;

    EBook(String ISBN, String title, String author, String fileFormat) {
        super(ISBN, title, author);
        this.fileFormat = fileFormat;
    }

    void displayEBookDetails() {
        System.out.println(
            "ISBN: " + ISBN +         
            ", Title: " + title +      
            ", Format: " + fileFormat +
            ", Author: " + getAuthor() 
        );
    }
}

