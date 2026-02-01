package com.streamapi.hospitaldoctoravailability;

import java.util.List;
import java.util.Comparator;

public class DoctorService {

    public List<Doctor> getWeekendAvailableDoctors(List<Doctor> doctors) {

        return doctors.stream()

                .filter(Doctor::isAvailableOnWeekend)

                .sorted(Comparator.comparing(Doctor::getSpecialty))

                .toList();
    }
}
