package com.librarymanagementsystem;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LibraryManagementSystem {

    private static final String URL = "jdbc:mysql://localhost:3306/librarydb";
    private static final String USER = "root";
    private static final String PASSWORD = "Akshay@2004";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        while (true) {

            System.out.println("\n1. View Book Inventory");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Books");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewInventory(con);
                    break;

                case 2:
                    borrowBook(con, sc);
                    break;

                case 3:
                    returnBook(con, sc);
                    break;

                case 4:
                    searchBooks(con, sc);
                    break;

                case 5:
                    con.close();
                    System.exit(0);
            }
        }
    }

    // View Inventory
    public static void viewInventory(Connection con) throws Exception {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM books");

        System.out.println("---- Book Inventory ----");

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("book_id")
                    + " | Title: " + rs.getString("name")
                    + " | Author: " + rs.getString("author")
                    + " | Total copies: " + rs.getString("total_copies")
                    + " | Available copies: " + rs.getInt("available_copies"));
        }
    }

    // Borrow Book
    public static void borrowBook(Connection con, Scanner sc) throws Exception {

        con.setAutoCommit(false);

        System.out.print("Student ID: ");
        int studentId = sc.nextInt();

        System.out.print("Book ID: ");
        int bookId = sc.nextInt();

        PreparedStatement check = con.prepareStatement(
                "SELECT available_copies FROM books WHERE book_id=?");
        check.setInt(1, bookId);
        ResultSet rs = check.executeQuery();

        if (!rs.next() || rs.getInt("available_copies") <= 0) {
            System.out.println("Book not available");
            con.rollback();
            return;
        }

        // Reduce copy
        PreparedStatement update = con.prepareStatement(
                "UPDATE books SET available_copies = available_copies - 1 WHERE book_id=?");
        update.setInt(1, bookId);
        update.executeUpdate();

        // Insert borrow record
        PreparedStatement insert = con.prepareStatement(
                "INSERT INTO borrow_records (student_id, book_id, borrow_date) VALUES (?, ?, CURDATE())");
        insert.setInt(1, studentId);
        insert.setInt(2, bookId);
        insert.executeUpdate();

        con.commit();
        System.out.println("Book Borrowed Successfully");
    }

    public static void returnBook(Connection con, Scanner sc) throws Exception {

        con.setAutoCommit(false);

        System.out.print("Record ID: ");
        int recordId = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "SELECT borrow_date, book_id FROM borrow_records WHERE record_id=?");
        ps.setInt(1, recordId);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            System.out.println("Record not found");
            return;
        }

        LocalDate borrowDate = rs.getDate("borrow_date").toLocalDate();
        int bookId = rs.getInt("book_id");
        LocalDate today = LocalDate.now();

        long days = ChronoUnit.DAYS.between(borrowDate, today);
        double fine = (days > 7) ? (days - 7) * 10 : 0; // ₹10 per extra day

        // Update return + fine
        PreparedStatement update = con.prepareStatement(
                "UPDATE borrow_records SET return_date=?, fine=? WHERE record_id=?");
        update.setDate(1, Date.valueOf(today));
        update.setDouble(2, fine);
        update.setInt(3, recordId);
        update.executeUpdate();

        // Increase available copy
        PreparedStatement bookUpdate = con.prepareStatement(
                "UPDATE books SET available_copies = available_copies + 1 WHERE book_id=?");
        bookUpdate.setInt(1, bookId);
        bookUpdate.executeUpdate();

        con.commit();

        System.out.println("Book Returned");
        System.out.println("Fine: ₹" + fine);
    }

    // Search with Multiple Filters
    public static void searchBooks(Connection con, Scanner sc) throws Exception {

        sc.nextLine(); 

        System.out.print("Enter Title (or press Enter to skip): ");
        String title = sc.nextLine();

        System.out.print("Enter Author (or press Enter to skip): ");
        String author = sc.nextLine();

        System.out.print("Enter Category (or press Enter to skip): ");
        String category = sc.nextLine();

        String query = "SELECT * FROM books WHERE 1=1";

        if (!title.isEmpty())
            query += " AND title LIKE '%" + title + "%'";
        if (!author.isEmpty())
            query += " AND author LIKE '%" + author + "%'";
        if (!category.isEmpty())
            query += " AND category LIKE '%" + category + "%'";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("---- Search Results ----");

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("book_id")
                    + " | Title: " + rs.getString("title")
                    + " | Author: " + rs.getString("author")
                    + " | Total copies: " + rs.getString("total_copies")
                    + " | Available copies: " + rs.getInt("available_copies"));
        }
    }
}
