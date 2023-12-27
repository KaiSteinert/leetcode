package org.example;

public class N69_Sqrt {
    /**
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
     * <p>
     * You must not use any built-in exponent function or operator.
     * <p>
     * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: x = 4<br>
     * Output: 2<br>
     * Explanation: The square root of 4 is 2, so we return 2.
     * <p>
     * Example 2:
     * <p>
     * Input: x = 8<br>
     * Output: 2<br>
     * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
     */
    public static int mySqrt(int x) {
        int idx = 0;
        while (idx <= x) {
            int tempResult = idx*idx;
            if (tempResult == x) {
                return idx;
            }
            if (tempResult > x || tempResult < 0) {
                return --idx;
            }
            idx++;
        }
        return 0;
    }
}
