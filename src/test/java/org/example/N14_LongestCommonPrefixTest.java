package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N14_LongestCommonPrefixTest {

    @Test
    public void longestCommonPrefixTest() {
        assertEquals("fl", N14_LongestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", N14_LongestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("", N14_LongestCommonPrefix.longestCommonPrefix(new String[]{""}));
        assertEquals("a", N14_LongestCommonPrefix.longestCommonPrefix(new String[]{"a"}));
    }
}
