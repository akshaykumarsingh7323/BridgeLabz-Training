package com.transactionmanagement;

import java.sql.*;
import java.util.Scanner;

public class BankingSystem {

    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Akshay@2004";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            con.setAutoCommit(false);

            System.out.println("1. Transfer Money");
            System.out.println("2. Check Balance");
            System.out.println("3. Transaction History");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    transferMoney(con, sc);
                    break;

                case 2:
                    checkBalance(con, sc);
                    break;

                case 3:
                    transactionHistory(con, sc);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Transfer Money Using Transaction
    public static void transferMoney(Connection con, Scanner sc) {

        try {

            System.out.print("\nFrom Account ID: ");
            int fromId = sc.nextInt();

            System.out.print("To Account ID: ");
            int toId = sc.nextInt();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();

            // Check sender balance
            PreparedStatement check = con.prepareStatement(
                    "SELECT balance FROM accounts WHERE id=?");
            check.setInt(1, fromId);
            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println("Sender Account Not Found");
                con.rollback();
                return;
            }

            double currentBalance = rs.getDouble("balance");

            if (currentBalance < amount) {
                System.out.println("Insufficient Balance");
                con.rollback();
                return;
            }

            // Deduct money
            PreparedStatement deduct = con.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id=?");
            deduct.setDouble(1, amount);
            deduct.setInt(2, fromId);
            deduct.executeUpdate();

            // Add money
            PreparedStatement add = con.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id=?");
            add.setDouble(1, amount);
            add.setInt(2, toId);
            add.executeUpdate();

            // Insert transaction record
            PreparedStatement insert = con.prepareStatement(
                    "INSERT INTO transactions (transaction_id, from_account, to_account, balance, transaction_date) VALUES (?, ?, ?, ?, CURDATE())");

            int txnId = (int)(Math.random() * 1000000); 
            insert.setInt(1, txnId);
            insert.setInt(2, fromId);
            insert.setInt(3, toId);
            insert.setDouble(4, amount);

            insert.executeUpdate();

            con.commit(); 
            System.out.println("Transfer Successful");

        } catch (Exception e) {
            try {
                con.rollback(); 
                System.out.println("Transaction Failed. Rolled Back.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    // Check Balance
    public static void checkBalance(Connection con, Scanner sc) throws SQLException {

        System.out.print("\nEnter Account ID: ");
        int id = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "SELECT balance FROM accounts WHERE id=?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Current Balance: " + rs.getDouble("balance"));
        } else {
            System.out.println("Account Not Found");
        }
    }

    // Transaction History
    public static void transactionHistory(Connection con, Scanner sc) throws SQLException {

        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM transactions WHERE from_account=? OR to_account=?");
        ps.setInt(1, id);
        ps.setInt(2, id);

        ResultSet rs = ps.executeQuery();

        System.out.println("---- Transaction History ----");

        while (rs.next()) {
            System.out.println("Txn ID: " + rs.getInt("transaction_id")
                    + " | From: " + rs.getInt("from_account")
                    + " | To: " + rs.getInt("to_account")
                    + " | Amount: " + rs.getDouble("balance")
                    + " | Date: " + rs.getDate("transaction_date"));
        }
    }
}
