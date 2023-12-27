package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N1_TwoSumTest {

    @Test
    public void twoSumTest() {
        N1_TwoSum cut = new N1_TwoSum();
        Assertions.assertArrayEquals(new int[]{0, 1}, cut.twoSum(new int[]{2,7,11,15}, 9));
        Assertions.assertArrayEquals(new int[]{1, 2}, cut.twoSum(new int[]{3,2,4}, 6));
        Assertions.assertArrayEquals(new int[]{0, 1}, cut.twoSum(new int[]{3, 3}, 6));
        Assertions.assertArrayEquals(new int[]{0, 2}, cut.twoSum(new int[]{3, 2, 3}, 6));
        Assertions.assertArrayEquals(new int[]{1, 2}, cut.twoSum(new int[]{2,5,5,11}, 10));

        Assertions.assertArrayEquals(new int[]{0, 1}, cut.twoSumFancy(new int[]{2,7,11,15}, 9));
        Assertions.assertArrayEquals(new int[]{1, 2}, cut.twoSumFancy(new int[]{3,2,4}, 6));
        Assertions.assertArrayEquals(new int[]{0, 1}, cut.twoSumFancy(new int[]{3, 3}, 6));
        Assertions.assertArrayEquals(new int[]{0, 2}, cut.twoSumFancy(new int[]{3, 2, 3}, 6));
        Assertions.assertArrayEquals(new int[]{1, 2}, cut.twoSumFancy(new int[]{2,5,5,11}, 10));
    }
}
