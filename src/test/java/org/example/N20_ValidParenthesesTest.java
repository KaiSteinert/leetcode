package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class N20_ValidParenthesesTest {

    @Test
    public void isValidTest(){
        assertTrue(N20_ValidParentheses.isValid("()"));
        assertTrue(N20_ValidParentheses.isValid("()[]{}"));
        assertFalse(N20_ValidParentheses.isValid("(}"));
        assertFalse(N20_ValidParentheses.isValid("["));
        assertFalse(N20_ValidParentheses.isValid("]"));
    }
}
