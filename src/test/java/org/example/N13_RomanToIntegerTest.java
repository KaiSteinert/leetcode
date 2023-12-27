package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N13_RomanToIntegerTest {

    @Test
    public void romanToIntTest() {
        assertEquals(3, N13_RomanToInteger.romanToInt("III"));
        assertEquals(58, N13_RomanToInteger.romanToInt("LVIII"));
        assertEquals(1994, N13_RomanToInteger.romanToInt("MCMXCIV"));
    }
}
