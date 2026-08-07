package com.healthclinic;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import com.healthclinic.dao.AppointmentDAO;
import com.healthclinic.dao.DepartmentDAO;
import com.healthclinic.dao.DoctorDAO;
import com.healthclinic.dao.PatientDAO;
import com.healthclinic.model.Appointment;
import com.healthclinic.model.Department;
import com.healthclinic.model.Doctor;
import com.healthclinic.model.Patient;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDAO departmentDAO = new DepartmentDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        PatientDAO patientDAO = new PatientDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        int choice;

        do {

            System.out.println("\n HEALTH CLINIC \n");
            System.out.println("1. Department");
            System.out.println("2. Doctor");
            System.out.println("3. Patient");
            System.out.println("4. Appointment");
            System.out.println("5. Exit");
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                departmentMenu(sc, departmentDAO);
                break;

            case 2:
                doctorMenu(sc, doctorDAO);
                break;

            case 3:
                patientMenu(sc, patientDAO);
                break;

            case 4:
                appointmentMenu(sc, appointmentDAO);
                break;

            case 5:
                System.out.println("Thank You...");
                break;

            default:
                System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }

    // DEPARTMENT

    public static void departmentMenu(Scanner sc, DepartmentDAO dao) {

        System.out.println("\n------ Department ------");
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.print("Enter Choice : ");

        int ch = sc.nextInt();

        switch (ch) {

        case 1:

            sc.nextLine();

            System.out.print("Department Name : ");
            String name = sc.nextLine();

            Department department = new Department();
            department.setDepartmentName(name);

            dao.addDepartment(department);
            break;

        case 2:

            dao.getAllDepartments();
            break;

        case 3:

            Department updateDepartment = new Department();

            System.out.print("Department ID : ");
            updateDepartment.setDepartmentId(sc.nextInt());

            sc.nextLine();

            System.out.print("New Department Name : ");
            updateDepartment.setDepartmentName(sc.nextLine());

            dao.updateDepartment(updateDepartment);
            break;

        case 4:

            System.out.print("Department ID : ");
            dao.deleteDepartment(sc.nextInt());
            break;

        default:
            System.out.println("Invalid Choice");
        }

    }

    //  DOCTOR 

    public static void doctorMenu(Scanner sc, DoctorDAO dao) {

        System.out.println("\n------ Doctor ------");
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.print("Enter Choice : ");

        int ch = sc.nextInt();

        switch (ch) {

        case 1:

            Doctor doctor = new Doctor();

            sc.nextLine();

            System.out.print("Doctor Name : ");
            doctor.setName(sc.nextLine());

            System.out.print("Specialty : ");
            doctor.setSpecialty(sc.nextLine());

            System.out.print("Department ID : ");
            doctor.setDepartmentId(sc.nextInt());

            dao.addDoctor(doctor);
            break;

        case 2:

            dao.getAllDoctors();
            break;

        case 3:

            Doctor updateDoctor = new Doctor();

            System.out.print("Doctor ID : ");
            updateDoctor.setDoctorId(sc.nextInt());

            sc.nextLine();

            System.out.print("Name : ");
            updateDoctor.setName(sc.nextLine());

            System.out.print("Specialty : ");
            updateDoctor.setSpecialty(sc.nextLine());

            System.out.print("Department ID : ");
            updateDoctor.setDepartmentId(sc.nextInt());

            dao.updateDoctor(updateDoctor);
            break;

        case 4:

            System.out.print("Doctor ID : ");
            dao.deleteDoctor(sc.nextInt());
            break;

        default:
            System.out.println("Invalid Choice");
        }

    }

    //  PATIENT 

    public static void patientMenu(Scanner sc, PatientDAO dao) {

        System.out.println("\n------ Patient ------");
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.print("Enter Choice : ");

        int ch = sc.nextInt();

        switch (ch) {

        case 1:

            Patient patient = new Patient();

            sc.nextLine();

            System.out.print("Name : ");
            patient.setName(sc.nextLine());

            System.out.print("Phone : ");
            patient.setPhone(sc.nextLine());

            System.out.print("DOB (yyyy-mm-dd) : ");
            patient.setDob(Date.valueOf(sc.nextLine()));

            System.out.print("Gender : ");
            patient.setGender(sc.nextLine());

            dao.addPatient(patient);
            break;

        case 2:

            dao.getAllPatients();
            break;

        case 3:

            Patient updatePatient = new Patient();

            System.out.print("Patient ID : ");
            updatePatient.setPatientId(sc.nextInt());

            sc.nextLine();

            System.out.print("Name : ");
            updatePatient.setName(sc.nextLine());

            System.out.print("Phone : ");
            updatePatient.setPhone(sc.nextLine());

            System.out.print("DOB (yyyy-mm-dd) : ");
            updatePatient.setDob(Date.valueOf(sc.nextLine()));

            System.out.print("Gender : ");
            updatePatient.setGender(sc.nextLine());

            dao.updatePatient(updatePatient);
            break;

        case 4:

            System.out.print("Patient ID : ");
            dao.deletePatient(sc.nextInt());
            break;

        default:
            System.out.println("Invalid Choice");
        }

    }

    //  APPOINTMENT 

    public static void appointmentMenu(Scanner sc, AppointmentDAO dao) {

        System.out.println("\n------ Appointment ------");
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.print("Enter Choice : ");

        int ch = sc.nextInt();

        switch (ch) {

        case 1:

            Appointment appointment = new Appointment();

            System.out.print("Patient ID : ");
            appointment.setPatientId(sc.nextInt());

            System.out.print("Doctor ID : ");
            appointment.setDoctorId(sc.nextInt());

            sc.nextLine();

            System.out.print("Appointment Date (yyyy-mm-dd hh:mm:ss) : ");
            appointment.setAppointmentDate(Timestamp.valueOf(sc.nextLine()));

            System.out.print("Status : ");
            appointment.setStatus(sc.nextLine());

            dao.addAppointment(appointment);
            break;

        case 2:

            dao.getAllAppointments();
            break;

        case 3:

            Appointment updateAppointment = new Appointment();

            System.out.print("Appointment ID : ");
            updateAppointment.setAppointmentId(sc.nextInt());

            System.out.print("Patient ID : ");
            updateAppointment.setPatientId(sc.nextInt());

            System.out.print("Doctor ID : ");
            updateAppointment.setDoctorId(sc.nextInt());

            sc.nextLine();

            System.out.print("Appointment Date (yyyy-mm-dd hh:mm:ss) : ");
            updateAppointment.setAppointmentDate(Timestamp.valueOf(sc.nextLine()));

            System.out.print("Status : ");
            updateAppointment.setStatus(sc.nextLine());

            dao.updateAppointment(updateAppointment);
            break;

        case 4:

            System.out.print("Appointment ID : ");
            dao.deleteAppointment(sc.nextInt());
            break;

        default:
            System.out.println("Invalid Choice");
        }
    }
}