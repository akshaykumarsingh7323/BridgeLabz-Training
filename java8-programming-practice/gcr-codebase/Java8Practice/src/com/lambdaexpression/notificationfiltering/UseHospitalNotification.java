package com.lambdaexpression.notificationfiltering;

import java.util.*;
import java.util.function.Predicate;

public class UseHospitalNotification {

    public static void main(String[] args) {

        List<Alert> alerts = List.of(
                new Alert("Heart rate abnormal", "CRITICAL"),
                new Alert("Medicine time reminder", "REMINDER"),
                new Alert("Daily health check completed", "NORMAL"),
                new Alert("Blood pressure very high", "CRITICAL")
        );

        Predicate<Alert> criticalFilter = alert -> alert.type.equals("CRITICAL");

        System.out.println("Showing Critical Alerts Only:");
        alerts.stream()
              .filter(criticalFilter)
              .forEach(System.out::println);
    }
}
