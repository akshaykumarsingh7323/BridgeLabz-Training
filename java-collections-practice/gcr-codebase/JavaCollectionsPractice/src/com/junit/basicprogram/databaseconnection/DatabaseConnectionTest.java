package com.junit.basicprogram.databaseconnection;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    DatabaseConnection db;

    //  Runs BEFORE each test
    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    //  Runs AFTER each test
    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(db.isConnected());
    }

    @Test
    void testConnectionStillActiveDuringTest() {
        assertTrue(db.isConnected());
    }
}

