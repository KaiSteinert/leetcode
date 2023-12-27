package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class N26_RemoveDublicatesFromSortedArrayTest {

    @Test
    public void removeDuplicatesTest() {
        int[] nums = new int[]{1, 1, 2};
        int[] expectedNums = new int[]{1, 2};
        assertEquals(expectedNums.length,
                N26_RemoveDublicatesFromSortedArray.removeDuplicates(nums));
        for (int idx=0; idx<expectedNums.length; idx++) {
            assertEquals(expectedNums[idx], nums[idx]);
        }

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        expectedNums = new int[]{0, 1, 2, 3, 4};
        assertEquals(expectedNums.length,
                N26_RemoveDublicatesFromSortedArray.removeDuplicates(nums));
        for (int idx=0; idx<expectedNums.length; idx++) {
            assertEquals(expectedNums[idx], nums[idx]);
        }

        nums = new int[]{0, 0, 0, 0, 0};
        expectedNums = new int[]{0};
        assertEquals(expectedNums.length,
                N26_RemoveDublicatesFromSortedArray.removeDuplicates(nums));
        for (int idx=0; idx<expectedNums.length; idx++) {
            assertEquals(expectedNums[idx], nums[idx]);
        }
    }
}
