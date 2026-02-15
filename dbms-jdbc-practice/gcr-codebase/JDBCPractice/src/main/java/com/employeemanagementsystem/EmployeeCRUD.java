package com.employeemanagementsystem;

import java.sql.*;

public class EmployeeCRUD {

    // ADD
    public static void addEmployee(String name, double salary) {

        String sql = "INSERT INTO employees(name, salary) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setDouble(2, salary);

            ps.executeUpdate();
            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW
    public static void viewEmployees() {

        String sql = "SELECT * FROM employees";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.printf("\n%-5s %-15s %-10s%n",
                    "ID", "Name", "Salary");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-15s %-10.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE SALARY
    public static void updateSalary(int id, double salary) {

        String sql = "UPDATE employees SET salary=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteEmployee(int id) {

        String sql = "DELETE FROM employees WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH BY NAME
    public static void searchByName(String name) {

        String sql = "SELECT * FROM employees WHERE name LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();
            
            if(!rs.next()) {
            	System.out.println("Record not found!");
            }
            
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " "
                                + rs.getString("name") + " "
                                + rs.getDouble("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
