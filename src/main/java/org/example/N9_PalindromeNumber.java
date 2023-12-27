package org.example;

import java.util.stream.IntStream;

public class N9_PalindromeNumber {
    /**
     * Given an integer x, return true if x is a palindrome, and false otherwise. <br>
     * <p>
     * Example 1: <br>
     * Input: x = 121 <br>
     * Output: true <br>
     * Explanation: 121 reads as 121 from left to right and from right to left. <br>
     * <p>
     * Example 2: <br>
     * Input: x = -121 <br>
     * Output: false <br>
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. <br>
     * Therefore it is not a palindrome. <br>
     * <p>
     * Example 3: <br>
     * Input: x = 10 <br>
     * Output: false <br>
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome. <br>
     */

    public static boolean palindromeNumber(int x) {
        String str = String.valueOf(x);
        int halfWay = (str.length() / 2) + 1;
        int otherWay = str.length() - 1;
        for (int index : IntStream.range(0, halfWay).toArray()) {
            if (str.charAt(index) != str.charAt(otherWay - index)) {
                return false;
            }
        }
        return true;
    }
}
