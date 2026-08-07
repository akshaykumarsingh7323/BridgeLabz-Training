package com.healthclinic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/health_clinic";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Akshay@2004";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database Connection Failed.");
            e.printStackTrace();
        }

        return connection;
    }
}