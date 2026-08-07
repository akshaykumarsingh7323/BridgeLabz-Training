package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Department;

public class DepartmentDAO {

    // INSERT
    public void addDepartment(Department department) {

        String sql = "INSERT INTO department(department_name) VALUES(?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, department.getDepartmentName());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Department Added Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT ALL
    public void getAllDepartments() {

        String sql = "SELECT * FROM department";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println("\n");
                System.out.println("Department ID   : " + rs.getInt("department_id"));
                System.out.println("Department Name : " + rs.getString("department_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateDepartment(Department department) {

        String sql = "UPDATE department SET department_name=? WHERE department_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, department.getDepartmentName());
            ps.setInt(2, department.getDepartmentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Department Updated Successfully.");
            } else {
                System.out.println("Department Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteDepartment(int departmentId) {

        String sql = "DELETE FROM department WHERE department_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, departmentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Department Deleted Successfully.");
            } else {
                System.out.println("Department Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}