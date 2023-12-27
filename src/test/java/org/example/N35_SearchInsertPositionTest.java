package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N35_SearchInsertPositionTest {

    @Test
    public void searchInsertTest(){
        assertEquals(2, N35_SearchInsertPosition
                .searchInsert(new int[]{1, 3, 5, 6, 7, 9, 10, 12, 13, 14, 15, 16, 18, 20, 23, 24, 25, 30, 31, 32, 33, 34, 38, 39, 41, 42, 43, 49, 80, 82, 83, 84}, 5));
        assertEquals(2, N35_SearchInsertPosition
                .searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, N35_SearchInsertPosition
                .searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, N35_SearchInsertPosition
                .searchInsert(new int[]{1, 3, 5, 6}, 7));
        assertEquals(5, N35_SearchInsertPosition
                .searchInsert(new int[]{1, 3, 5, 6, 7}, 8));
        assertEquals(0, N35_SearchInsertPosition
                .searchInsert(new int[]{2, 3, 5, 6, 7}, 1));
        assertEquals(0, N35_SearchInsertPosition
                .searchInsert(new int[]{}, 1));
        assertEquals(0, N35_SearchInsertPosition
                .searchInsert(new int[]{1}, 1));
    }
}
