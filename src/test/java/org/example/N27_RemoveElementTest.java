package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N27_RemoveElementTest {

    @Test
    public void removeElementTest() {
        int[] nums = new int[]{3, 2, 2, 3};
        int[] expectedNums = new int[]{2, 2};
        assertEquals(expectedNums.length, N27_RemoveElement.removeElement(nums, 3));
        for (int idx=0; idx<expectedNums.length; idx++) {
            assertEquals(expectedNums[idx], nums[idx]);
        }

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        expectedNums = new int[]{0, 1, 4, 0, 3};
        assertEquals(expectedNums.length, N27_RemoveElement.removeElement(nums, 2));
        for (int idx=0; idx<expectedNums.length; idx++) {
            assertEquals(expectedNums[idx], nums[idx]);
        }

        nums = new int[]{2};
        expectedNums = new int[]{2};
        assertEquals(expectedNums.length, N27_RemoveElement.removeElement(nums, 3));
        for (int idx=0; idx<expectedNums.length; idx++) {
            assertEquals(expectedNums[idx], nums[idx]);
        }

        nums = new int[]{3, 3};
        expectedNums = new int[]{};
        assertEquals(expectedNums.length, N27_RemoveElement.removeElement(nums, 3));
        for (int idx=0; idx<expectedNums.length; idx++) {
            assertEquals(expectedNums[idx], nums[idx]);
        }

        nums = new int[]{3, 3};
        expectedNums = new int[]{3, 3};
        assertEquals(expectedNums.length, N27_RemoveElement.removeElement(nums, 5));
        for (int idx=0; idx<expectedNums.length; idx++) {
            assertEquals(expectedNums[idx], nums[idx]);
        }
    }
}
