package com.junit.advanceproblem.testingpasswordstrength;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junit.advanceproblem.testingpasswordstrength.PasswordValidator;

public class PasswordValidatorTest {

    PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
    }

    @Test
    void testShortPassword() {
        assertFalse(validator.isValid("Pass1"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }

    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}
