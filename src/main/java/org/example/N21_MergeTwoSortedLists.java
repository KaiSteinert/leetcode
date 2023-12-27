package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class N21_MergeTwoSortedLists {

    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     * <p>
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * <p>
     * Return the head of the merged linked list.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: list1 = [1,2,4], list2 = [1,3,4]<br>
     * Output: [1,1,2,3,4,4]
     * <p>
     * Example 2:
     * <p>
     * Input: list1 = [], list2 = []<br>
     * Output: []
     * <p>
     * Example 3:
     * <p>
     * Input: list1 = [], list2 = [0]<br>
     * Output: [0]
     */

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int[] toArray() {
            List<Integer> result = new ArrayList<>();
            ListNode node = this;
            while (nonNull(node.next)) {
                result.add(node.val);
                node = node.next;
            }
            if(nonNull(node.val)){
                result.add(node.val);
            }
            return result.stream().mapToInt(i->i).toArray();
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (isNull(list1) && isNull(list2)) {
            return null;
        }
        if (isNull(list1)) {
            return list2;
        }
        if (isNull(list2)) {
            return list1;
        }
        if (list1.val < list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        }
        if (list2.val <= list1.val) {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }
        return null;
    }
}
