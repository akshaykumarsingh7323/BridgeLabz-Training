package com.linkedlist.doublylinkedlist.librarymanagementsystem;

class Library {
    private Book head;
    private Book tail;


    public void addAtBeginning(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(int position, Book newBook) {
        if (position <= 1 || head == null) {
            addAtBeginning(newBook);
            return;
        }

        Book temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            addAtEnd(newBook);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
        }
    }


    public void removeByBookId(int bookId) {
        if (head == null) return;

        Book temp = head;

        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) return; 

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } 
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } 
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }


    public Book searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public Book searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author))
                return temp;
            temp = temp.next;
        }
        return null;
    }


    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }


    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    private void printBook(Book book) {
        System.out.println(
            book.bookId + " | " +
            book.title + " | " +
            book.author + " | " +
            book.genre + " | " +
            (book.isAvailable ? "Available" : "Issued")
        );
    }


    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
