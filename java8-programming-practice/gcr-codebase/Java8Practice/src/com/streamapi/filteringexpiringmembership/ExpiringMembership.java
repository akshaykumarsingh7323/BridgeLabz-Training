package com.streamapi.filteringexpiringmembership;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpiringMembership {

    public static void main(String[] args) {

        List<GymMember> members = Arrays.asList(
                new GymMember("Amit", LocalDate.now().plusDays(10)),
                new GymMember("Ravi", LocalDate.now().plusDays(40)),
                new GymMember("Neha", LocalDate.now().plusDays(25))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<GymMember> expiringSoon =
                members.stream()
                       .filter(m -> m.expiryDate.isAfter(today)
                                 && m.expiryDate.isBefore(next30Days))
                       .collect(Collectors.toList());

        System.out.println("Members expiring within 30 days:");
        expiringSoon.forEach(m ->
                System.out.println(m.name + " → " + m.expiryDate)
        );
    }
}

