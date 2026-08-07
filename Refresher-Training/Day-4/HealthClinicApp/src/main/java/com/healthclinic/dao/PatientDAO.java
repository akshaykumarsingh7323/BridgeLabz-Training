package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Patient;

public class PatientDAO {

    // INSERT
    public void addPatient(Patient patient) {

        String sql = "INSERT INTO patient(name, phone, dob, gender) VALUES(?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setString(2, patient.getPhone());
            ps.setDate(3, patient.getDob());
            ps.setString(4, patient.getGender());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Added Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT ALL
    public void getAllPatients() {

        String sql = "SELECT * FROM patient";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
        	
        	boolean found = false;

        	while (rs.next()) {

        	    found = true;

        	    System.out.println("\n");
        	    System.out.println("Patient ID : " + rs.getInt("patient_id"));
        	    System.out.println("Name       : " + rs.getString("name"));
        	    System.out.println("Phone      : " + rs.getString("phone"));
        	    System.out.println("DOB        : " + rs.getDate("dob"));
        	    System.out.println("Gender     : " + rs.getString("gender"));
        	}

        	if (!found) {
        	    System.out.println("No Records Found.");
        	}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH BY ID
    public void getPatientById(int patientId) {

        String sql = "SELECT * FROM patient WHERE patient_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n");
                System.out.println("Patient ID : " + rs.getInt("patient_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("DOB        : " + rs.getDate("dob"));
                System.out.println("Gender     : " + rs.getString("gender"));

            } else {
                System.out.println("Patient Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updatePatient(Patient patient) {

        String sql = "UPDATE patient SET name=?, phone=?, dob=?, gender=? WHERE patient_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setString(2, patient.getPhone());
            ps.setDate(3, patient.getDob());
            ps.setString(4, patient.getGender());
            ps.setInt(5, patient.getPatientId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Updated Successfully.");
            } else {
                System.out.println("Patient Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletePatient(int patientId) {

        String sql = "DELETE FROM patient WHERE patient_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Deleted Successfully.");
            } else {
                System.out.println("Patient Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}