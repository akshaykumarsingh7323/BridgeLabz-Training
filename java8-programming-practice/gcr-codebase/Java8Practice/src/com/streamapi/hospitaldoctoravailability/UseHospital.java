package com.streamapi.hospitaldoctoravailability;

import java.util.List;

public class UseHospital {

    public static void main(String[] args) {

        List<Doctor> doctors = List.of(
                new Doctor("Dr. Sharma", "Cardiology", true),
                new Doctor("Dr. Mehta", "Neurology", false),
                new Doctor("Dr. Khan", "Orthopedics", true),
                new Doctor("Dr. Singh", "Dermatology", true),
                new Doctor("Dr. Roy", "Neurology", true)
        );

        DoctorService service = new DoctorService();

        List<Doctor> weekendDoctors =
                service.getWeekendAvailableDoctors(doctors);

        weekendDoctors.forEach(System.out::println);
    }
}
