package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

public class N66_PlusOne {
    /**
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
     * <p>
     * Increment the large integer by one and return the resulting array of digits.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: digits = [1,2,3]<br>
     * Output: [1,2,4]<br>
     * Explanation: The array represents the integer 123.<br>
     * Incrementing by one gives 123 + 1 = 124.<br>
     * Thus, the result should be [1,2,4].
     * <p>
     * Example 2:
     * <p>
     * Input: digits = [4,3,2,1]<br>
     * Output: [4,3,2,2]<br>
     * Explanation: The array represents the integer 4321.<br>
     * Incrementing by one gives 4321 + 1 = 4322.<br>
     * Thus, the result should be [4,3,2,2].
     * <p>
     * Example 3:
     * <p>
     * Input: digits = [9]<br>
     * Output: [1,0]<br>
     * Explanation: The array represents the integer 9.<br>
     * Incrementing by one gives 9 + 1 = 10.<br>
     * Thus, the result should be [1,0].
     */
    static <T> T[] concatArrays(T[] array1, T[] array2) {
        return Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .toArray(size -> (T[]) Array.newInstance(array1.getClass().getComponentType(), size));
    }

    private static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }

    private static int[] plusOneRecursive(int[] digits, int lastIdx) {
        if (lastIdx < 0) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            return newDigits;
        }
        if (digits[lastIdx] == 9){
            digits[lastIdx] = 0;
            return plusOneRecursive(digits, lastIdx-1);
        } else {
            digits[lastIdx] = digits[lastIdx] + 1;
            return digits;
        }
    }

    public static int[] plusOne(int[] digits) {
        if (isNull(digits) || isEmpty(digits)) {
            return new int[]{};
        }
        return plusOneRecursive(
                Arrays.copyOf(digits, digits.length),
                digits.length-1);
    }
}
