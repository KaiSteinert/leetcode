package org.example;

import java.util.Map;

public class N13_RomanToInteger {
    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.<br>
     * <p>
     * Symbol       Value<br>
     * I             1<br>
     * V             5<br>
     * X             10<br>
     * L             50<br>
     * C             100<br>
     * D             500<br>
     * M             1000<br>
     * <p>
     * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.<br>
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.<br>
     * X can be placed before L (50) and C (100) to make 40 and 90.<br>
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * <p>
     * Given a roman numeral, convert it to an integer.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "III"<br>
     * Output: 3<br>
     * Explanation: III = 3.
     * <p>
     * Example 2:
     * <p>
     * Input: s = "LVIII"<br>
     * Output: 58<br>
     * Explanation: L = 50, V= 5, III = 3.
     * <p>
     * Example 3:
     * <p>
     * Input: s = "MCMXCIV"<br>
     * Output: 1994<br>
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    public static int romanToInt(String s) {
        Map<String, Integer> romanNumeral = Map.ofEntries(
                Map.entry("I", 1),
                Map.entry("V", 5),
                Map.entry("X", 10),
                Map.entry("L", 50),
                Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000));
        int result = 0;
        int register = 0;
        int current;
        for (int idx = s.length() - 1; idx >= 0; idx--) {
            current = romanNumeral.get(String.valueOf(s.charAt(idx)));
            if (current < register) {
                result = result - current;
            } else {
                result = result + current;
                register = current;
            }
        }
        return result;
    }
}
