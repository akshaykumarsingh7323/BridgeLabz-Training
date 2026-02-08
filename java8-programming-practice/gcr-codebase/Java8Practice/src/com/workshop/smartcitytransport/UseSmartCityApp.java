package com.workshop.smartcitytransport;

import java.util.*;

import java.util.*;
import java.util.stream.*;

public class UseSmartCityApp {

    public static void main(String[] args) {

        List<TransportService> services = Arrays.asList(
                new BusService(),
                new MetroService(),
                new TaxiService(),
                new AmbulanceService()
        );

        System.out.println("\n--- Available Services (Sorted by Time) ---");
        services.stream()
                .filter(s -> s.getFare() <= 100)
                .sorted(Comparator.comparingInt(TransportService::getDepartureTime))
                .forEach(TransportService::printServiceDetails);

        System.out.println("\n--- Live Dashboard ---");
        services.forEach(TransportService::printServiceDetails);

        FareCalculator taxiFare = distance -> distance * 15;
        double distance = GeoUtils.calculateDistance(12.1, 12.6);
        System.out.println("\nTaxi Fare for distance: Rs " + taxiFare.calculateFare(distance));

        List<Passenger> passengers = Arrays.asList(
                new Passenger("Amit", "A-B", 40, true),
                new Passenger("Riya", "A-C", 60, false),
                new Passenger("John", "A-B", 40, true),
                new Passenger("Neha", "B-C", 120, false)
        );

        System.out.println("\n--- Passengers Grouped by Route ---");
        Map<String, List<Passenger>> byRoute =
                passengers.stream().collect(Collectors.groupingBy(p -> p.route));
        byRoute.forEach((k, v) -> System.out.println(k + " -> " + v.size()));

        System.out.println("\n--- Peak vs Non-Peak ---");
        Map<Boolean, List<Passenger>> peakData =
                passengers.stream().collect(Collectors.partitioningBy(p -> p.peakTime));
        System.out.println(peakData);

        DoubleSummaryStatistics stats =
                passengers.stream().collect(Collectors.summarizingDouble(p -> p.fare));
        System.out.println("\nTotal Revenue: Rs " + stats.getSum());
        System.out.println("Average Fare: Rs " + stats.getAverage());

        System.out.println("\n--- Emergency Services ---");
        services.stream()
                .filter(s -> s instanceof EmergencyService)
                .forEach(s -> System.out.println(s.getServiceName() + " gets priority"));
    }
}
