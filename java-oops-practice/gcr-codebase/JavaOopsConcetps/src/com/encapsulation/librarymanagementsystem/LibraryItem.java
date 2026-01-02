package com.encapsulation.librarymanagementsystem;

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    private String borrowerName;
    private boolean isAvailable = true;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    protected void borrowItem(String borrower) {
        if (isAvailable) {
            this.borrowerName = borrower;
            this.isAvailable = false;
            System.out.println("Borrowed by: " + borrower);
        } else {
            System.out.println("Item not available");
        }
    }

    protected void returnItem() {
        borrowerName = null;
        isAvailable = true;
        System.out.println("Item returned successfully");
    }

    protected boolean isAvailable() {
        return isAvailable;
    }

    public abstract int getLoanDuration();
}
