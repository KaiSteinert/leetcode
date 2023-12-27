package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class N83_RemoveDuplicatesFromSortedList {

    /**
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: head = [1,1,2]<br>
     * Output: [1,2]
     * <p>
     * Example 2:
     * <p>
     * Input: head = [1,1,2,3,3]<br>
     * Output: [1,2,3]
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int[] toArray() {
            List<Integer> result = new ArrayList<>();
            ListNode current = this;
            while (current.next != null) {
                result.add(current.val);
                current = current.next;
            };
            result.add(current.val);
            return result.stream().mapToInt(x->x).toArray();
        }
    }

    public ListNode deleteDuplicatesTopSubmission(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val)
                curr.next = curr.next.next;
            curr = curr.next;
        }

        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (isNull(head)) {
            return null;
        }
        ListNode resultHead = new ListNode();
        ListNode result = resultHead;
        result.val = head.val;
        ListNode prev = null;
        ListNode current = head;
        while (nonNull(current.next)) {
            if(nonNull(prev)) {
                if (prev.val != current.val) {
                    result.next = new ListNode(current.val);
                    result = result.next;
                    prev = current;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        if (nonNull(prev) && prev.val != current.val) {
            result.next = new ListNode(current.val);
        }
        return resultHead;
    }
}
