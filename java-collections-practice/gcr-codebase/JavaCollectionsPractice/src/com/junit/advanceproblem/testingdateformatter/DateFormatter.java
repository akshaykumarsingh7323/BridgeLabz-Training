package com.junit.advanceproblem.testingdateformatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public String formatDate(String inputDate) {
        if (inputDate == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(inputDate, inputFormat);
        return date.format(outputFormat);
    }
}
