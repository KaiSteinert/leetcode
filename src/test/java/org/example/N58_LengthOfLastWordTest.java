package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N58_LengthOfLastWordTest {

    @Test
    public void lengthOfLastWord() {
        assertEquals(5, N58_LengthOfLastWord
                .lengthOfLastWord("Hello World"));

        assertEquals(4, N58_LengthOfLastWord
                .lengthOfLastWord("   fly me   to   the moon  "));

        assertEquals(6, N58_LengthOfLastWord
                .lengthOfLastWord("luffy is still joyboy"));

        assertEquals(0, N58_LengthOfLastWord
                .lengthOfLastWord("  "));
    }
}
