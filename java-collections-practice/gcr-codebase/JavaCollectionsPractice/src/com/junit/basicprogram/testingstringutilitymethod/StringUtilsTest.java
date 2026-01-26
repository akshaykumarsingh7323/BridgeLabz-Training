package com.junit.basicprogram.testingstringutilitymethod;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
    }

    @Test
    void testIsPalindromeTrue() {
        assertTrue(utils.isPalindrome("madam"));
    }

    @Test
    void testIsPalindromeFalse() {
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("JAVA", utils.toUpperCase("java"));
    }
}
