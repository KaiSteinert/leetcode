package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N28_FindTheIndexOfTheFirstOccurrenceInAStringTest {

    @Test
    public void strStrTest(){
        assertEquals(0, N28_FindTheIndexOfTheFirstOccurrenceInAString
                .strStr("sadbutsad", "sad"));
        assertEquals(-1, N28_FindTheIndexOfTheFirstOccurrenceInAString
                .strStr("leetcode", "leeto"));
        assertEquals(3, N28_FindTheIndexOfTheFirstOccurrenceInAString
                .strStr("sadbuttrue", "but"));
        assertEquals(-1, N28_FindTheIndexOfTheFirstOccurrenceInAString
                .strStr("aaa", "aaaa"));
        assertEquals(-1, N28_FindTheIndexOfTheFirstOccurrenceInAString
                .strStr("kaiser", "era"));
    }
}
