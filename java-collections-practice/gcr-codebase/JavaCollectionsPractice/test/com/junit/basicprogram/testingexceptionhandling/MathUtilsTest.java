package com.junit.basicprogram.testingexceptionhandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    MathUtils utils = new MathUtils();

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            utils.divide(10, 0);
        });
    }

    @Test
    void testDivideNormally() {
        assertEquals(5, utils.divide(10, 2));
    }
}
