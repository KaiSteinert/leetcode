package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N66_PlusOneTest {

    @Test
    public void plusOneTest(){
        Assertions.assertArrayEquals(new int[]{1, 2, 4},
                N66_PlusOne.plusOne(new int[]{1, 2, 3}));
        Assertions.assertArrayEquals(new int[]{4, 3, 2, 2},
                N66_PlusOne.plusOne(new int[]{4, 3, 2, 1}));
        Assertions.assertArrayEquals(new int[]{1, 0},
                N66_PlusOne.plusOne(new int[]{9}));
    }
}
