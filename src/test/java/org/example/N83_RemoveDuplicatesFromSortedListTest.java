package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N83_RemoveDuplicatesFromSortedListTest {

    @Test
    public void deleteDuplicatesTest(){
        N83_RemoveDuplicatesFromSortedList obj = new N83_RemoveDuplicatesFromSortedList();
        Assertions.assertArrayEquals(new int[]{1, 2, 3},
                obj.deleteDuplicates(obj.new ListNode(1,
                        obj.new ListNode(1,
                                obj.new ListNode(2,
                                        obj.new ListNode(3,
                                                obj.new ListNode(3)))))).toArray());
        Assertions.assertArrayEquals(new int[]{1, 2},
                obj.deleteDuplicates(obj.new ListNode(1,
                        obj.new ListNode(1,
                                obj.new ListNode(2, null)))).toArray());
    }
}
