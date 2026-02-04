package com.junit.advanceproblem.testingdateformatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

public class DateFormatterTest {

    DateFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new DateFormatter();
    }

    @Test
    void testValidDate() {
        String result = formatter.formatDate("2024-08-15");
        assertEquals("15-08-2024", result);
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(DateTimeParseException.class, () -> {
            formatter.formatDate("15-08-2024");
        });
    }

    @Test
    void testInvalidDateValue() {
        assertThrows(DateTimeParseException.class, () -> {
            formatter.formatDate("2024-13-40");
        });
    }

    @Test
    void testNullDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate(null);
        });
    }
}
