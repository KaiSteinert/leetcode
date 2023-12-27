package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N88_MergeSortedArrayTest {

    @Test
    public void mergeTest() {
        int[] testObj = new int[]{4, 5, 6, 0, 0, 0};
        N88_MergeSortedArray.merge(
                testObj, 3,
                new int[]{1, 2, 3}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, testObj);

        testObj = new int[]{1, 2, 3, 0, 0, 0};
        N88_MergeSortedArray.merge(
                testObj, 3,
                new int[]{2, 5, 6}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, testObj);

        testObj = new int[]{1};
        N88_MergeSortedArray.merge(
                testObj, 1,
                new int[]{}, 0);
        Assertions.assertArrayEquals(new int[]{1}, testObj);

        testObj = new int[]{0};
        N88_MergeSortedArray.merge(
                testObj, 0,
                new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1}, testObj);
    }
}
