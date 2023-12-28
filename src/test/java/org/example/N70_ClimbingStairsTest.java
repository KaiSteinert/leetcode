package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N70_ClimbingStairsTest {

    @Test
    public void climbStairsTest() {
        // N70_ClimbingStairs.climbStairs(4);
        assertEquals(5, N70_ClimbingStairs.climbStairs(4));
        assertEquals(3, N70_ClimbingStairs.climbStairs(3));
        assertEquals(55, N70_ClimbingStairs.climbStairs(9));
        assertEquals(1, N70_ClimbingStairs.climbStairs(1));
        assertEquals(2, N70_ClimbingStairs.climbStairs(2));
        assertEquals(8, N70_ClimbingStairs.climbStairs(5));
        assertEquals(21, N70_ClimbingStairs.climbStairs(7));
        //assertEquals(3, N70_ClimbingStairs.climbStairs(35));
    }
}
