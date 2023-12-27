package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class N9_PalindromeNumberTest {

    @Test
    public void palindromeNumber() {
        assertTrue(N9_PalindromeNumber.palindromeNumber(121));
        assertFalse(N9_PalindromeNumber.palindromeNumber(-121));
        assertFalse(N9_PalindromeNumber.palindromeNumber(10));
    }
}
