package com.librarymanagementsystem;

public class Member {

    private String memberName;

    public Member(String memberName) {
        this.memberName = memberName;
    }

    public void issueBook(Book book) {
        if (!book.isIssued()) {
            book.issueBook();
            System.out.println(memberName + " issued the book: " + book.getTitle());
        } else {
            System.out.println("Book is already issued!");
        }
    }

    public double calculateFine(int lateDays) {
        return lateDays * 5;
    }

    public void returnBook(Book book, int lateDays) {
        book.returnBook();
        double fine = calculateFine(lateDays);

        System.out.println("Book returned: " + book.getTitle());
        System.out.println("Late Days: " + lateDays);
        System.out.println("Fine Amount: ₹" + fine);
    }
}

