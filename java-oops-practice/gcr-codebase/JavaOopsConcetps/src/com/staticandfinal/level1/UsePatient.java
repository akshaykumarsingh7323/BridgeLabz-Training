package com.staticandfinal.level1;

public class UsePatient {

	public static void main(String[] args) {
	   System.out.println("\n----- Hospital Management System -----\n");

	   Patient.setHospitalName("City Hospital");

	   Patient patient1 = new Patient("Lathika", 30, "Flu", "P001");
       Patient patient2 = new Patient("Lidiya", 45, "Fracture", "P002");

       System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());

       patient1.displayPatientDetails();
       
       System.out.println();
       
       patient2.displayPatientDetails();

	}
}
