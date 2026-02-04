package com.junit.advanceproblem.testinguserregistration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    UserRegistration registration;

    @BeforeEach
    void setUp() {
        registration = new UserRegistration();
    }

    @Test
    void testValidUserRegistration() {
        assertTrue(registration.registerUser(
                "john123",
                "john@example.com",
                "Password1"
        ));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("jo", "john@example.com", "Password1");
        });
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john123", "johnexample.com", "Password1");
        });
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("john123", "john@example.com", "pass");
        });
    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(null, null, null);
        });
    }
}

