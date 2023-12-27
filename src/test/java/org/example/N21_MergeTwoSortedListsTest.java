package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class N21_MergeTwoSortedListsTest {

    @Test
    public void mergeTwoListsTest() {
        N21_MergeTwoSortedLists obj = new N21_MergeTwoSortedLists();
        N21_MergeTwoSortedLists.ListNode list1 = obj.new ListNode(
                1, obj.new ListNode(
                        2, obj.new ListNode(
                                4)));
        N21_MergeTwoSortedLists.ListNode list2 = obj.new ListNode(
                1, obj.new ListNode(
                        3, obj.new ListNode(
                                4)));
        Assertions.assertArrayEquals(new int[]{1, 2, 4},
                list1.toArray());
        Assertions.assertArrayEquals(new int[]{1, 3, 4},
                list2.toArray());

        Assertions.assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4},
                Optional.ofNullable(obj.mergeTwoLists(list1, list2))
                        .orElseThrow().toArray());
    }
}
