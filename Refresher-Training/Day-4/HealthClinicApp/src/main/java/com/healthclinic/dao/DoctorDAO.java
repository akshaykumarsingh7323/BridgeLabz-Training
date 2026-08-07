package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Doctor;

public class DoctorDAO {

    // INSERT
    public void addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctor(name, specialty, department_id) VALUES(?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialty());
            ps.setInt(3, doctor.getDepartmentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Doctor Added Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT ALL
    public void getAllDoctors() {

        String sql = "SELECT * FROM doctor";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println("\n");
                System.out.println("Doctor ID      : " + rs.getInt("doctor_id"));
                System.out.println("Name           : " + rs.getString("name"));
                System.out.println("Specialty      : " + rs.getString("specialty"));
                System.out.println("Department ID  : " + rs.getInt("department_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateDoctor(Doctor doctor) {

        String sql = "UPDATE doctor SET name=?, specialty=?, department_id=? WHERE doctor_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialty());
            ps.setInt(3, doctor.getDepartmentId());
            ps.setInt(4, doctor.getDoctorId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Doctor Updated Successfully.");
            } else {
                System.out.println("Doctor Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteDoctor(int doctorId) {

        String sql = "DELETE FROM doctor WHERE doctor_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Doctor Deleted Successfully.");
            } else {
                System.out.println("Doctor Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH BY ID
    public void getDoctorById(int doctorId) {

        String sql = "SELECT * FROM doctor WHERE doctor_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n");
                System.out.println("Doctor ID      : " + rs.getInt("doctor_id"));
                System.out.println("Name           : " + rs.getString("name"));
                System.out.println("Specialty      : " + rs.getString("specialty"));
                System.out.println("Department ID  : " + rs.getInt("department_id"));

            } else {
                System.out.println("Doctor Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}