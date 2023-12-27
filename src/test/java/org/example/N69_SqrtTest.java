package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N69_SqrtTest {

    @Test
    public void mySqrt(){
        assertEquals(46340, N69_Sqrt.mySqrt(2147483647));
        assertEquals(2, N69_Sqrt.mySqrt(4));
        assertEquals(2, N69_Sqrt.mySqrt(8));
        assertEquals(3, N69_Sqrt.mySqrt(9));
        assertEquals(9, N69_Sqrt.mySqrt(81));
        assertEquals(9, N69_Sqrt.mySqrt(82));
        assertEquals(0, N69_Sqrt.mySqrt(0));
        assertEquals(1, N69_Sqrt.mySqrt(1));
    }
}
