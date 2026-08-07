package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Appointment;

public class AppointmentDAO {

    // INSERT
    public void addAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointment(patient_id, doctor_id, appointment_date, status) VALUES(?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setTimestamp(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Appointment Added Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT ALL
    public void getAllAppointments() {

        String sql = "SELECT * FROM appointment";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println("\n");
                System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
                System.out.println("Patient ID     : " + rs.getInt("patient_id"));
                System.out.println("Doctor ID      : " + rs.getInt("doctor_id"));
                System.out.println("Date & Time    : " + rs.getTimestamp("appointment_date"));
                System.out.println("Status         : " + rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH BY ID
    public void getAppointmentById(int appointmentId) {

        String sql = "SELECT * FROM appointment WHERE appointment_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n");
                System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
                System.out.println("Patient ID     : " + rs.getInt("patient_id"));
                System.out.println("Doctor ID      : " + rs.getInt("doctor_id"));
                System.out.println("Date & Time    : " + rs.getTimestamp("appointment_date"));
                System.out.println("Status         : " + rs.getString("status"));

            } else {
                System.out.println("Appointment Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateAppointment(Appointment appointment) {

        String sql = "UPDATE appointment SET patient_id=?, doctor_id=?, appointment_date=?, status=? WHERE appointment_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setTimestamp(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getStatus());
            ps.setInt(5, appointment.getAppointmentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Appointment Updated Successfully.");
            } else {
                System.out.println("Appointment Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteAppointment(int appointmentId) {

        String sql = "DELETE FROM appointment WHERE appointment_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Appointment Deleted Successfully.");
            } else {
                System.out.println("Appointment Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}