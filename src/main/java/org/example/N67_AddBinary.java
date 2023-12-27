package org.example;

import java.math.BigInteger;

import static java.util.Objects.isNull;

public class N67_AddBinary {
    /**
     * Given two binary strings a and b, return their sum as a binary string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: a = "11", b = "1"<br>
     * Output: "100"
     * <p>
     * Example 2:
     * <p>
     * Input: a = "1010", b = "1011"<br>
     * Output: "10101"
     */
    public static String addBinarySmall(String a, String b) {
        int sum = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        return Integer.toBinaryString(sum);
    }

    public static String addBinaryBigInt(String a, String b) {
        BigInteger aInt = new BigInteger(a, 2);
        BigInteger bInt = new BigInteger(b, 2);
        return aInt.add(bInt).toString(2);
    }

    private static boolean addBinaryChars(StringBuilder builder, Character a, Character b, boolean carrie) {
        if (a == '0' && b == '0' && !carrie) {
            builder.append('0');
            return false;
        }
        if (a == '0' && b == '0' && carrie) {
            builder.append('1');
            return false;
        }
        if (a == '1' && b == '1' && !carrie) {
            builder.append('0');
            return true;
        }
        if (a == '1' && b == '1' && carrie) {
            builder.append('1');
            return true;
        }
        if (a == '0' && b == '1' && !carrie) {
            builder.append('1');
            return false;
        }
        if (a == '1' && b == '0' && !carrie) {
            builder.append('1');
            return false;
        }
        if (a == '0' && b == '1' && carrie) {
            builder.append('0');
            return true;
        }
        if (a == '1' && b == '0' && carrie) {
            builder.append('0');
            return true;
        }
        return false;
    }

    public static String addBinary(String a, String b) {
        if (isNull(a) || a.isEmpty()) {
            return b;
        }
        if (isNull(b) || b.isEmpty()) {
            return a;
        }
        StringBuilder builder = new StringBuilder();
        boolean carrie = false;
        int aIdx = a.length()-1;
        int bIdx = b.length()-1;
        while (aIdx > -1 || bIdx > -1) {
            if(aIdx >= 0 && bIdx >= 0) {
                carrie = addBinaryChars(builder, a.charAt(aIdx), b.charAt(bIdx), carrie);
            }
            if (aIdx < 0) {
                carrie = addBinaryChars(builder, '0', b.charAt(bIdx), carrie);
            }
            if (bIdx < 0) {
                carrie = addBinaryChars(builder, a.charAt(aIdx), '0', carrie);
            }
            aIdx--;
            bIdx--;
        }
        if(carrie) {
            builder.append('1');
        }
        return builder.reverse().toString();
    }
}
