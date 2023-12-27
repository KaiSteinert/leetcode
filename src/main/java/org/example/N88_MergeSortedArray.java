package org.example;

public class N88_MergeSortedArray {

    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     * <p>
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * <p>
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3<br>
     * Output: [1,2,2,3,5,6]<br>
     * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].<br>
     * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     * <p>
     * Example 2:
     * <p>
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0<br>
     * Output: [1]<br>
     * Explanation: The arrays we are merging are [1] and [].<br>
     * The result of the merge is [1].
     * <p>
     * Example 3:
     * <p>
     * Input: nums1 = [0], m = 0, nums2 = [1], n = 1<br>
     * Output: [1]<br>
     * Explanation: The arrays we are merging are [] and [1].<br>
     * The result of the merge is [1].<br>
     * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int resultIdx = nums1.length-1;
        int nums1Idx = m-1;
        int nums2Idx = n-1;
        while (resultIdx >= 0) {
            boolean num1Valid = nums1Idx >= 0;
            boolean num2Valid = nums2Idx >= 0;
            if (num1Valid && num2Valid && nums2[nums2Idx] > nums1[nums1Idx]) {
                nums1[resultIdx] = nums2[nums2Idx];
                --nums2Idx;
                --resultIdx;
                continue;
            }
            if (num1Valid && num2Valid && nums2[nums2Idx] <= nums1[nums1Idx]) {
                nums1[resultIdx] = nums1[nums1Idx];
                --nums1Idx;
                --resultIdx;
                continue;
            }
            if (num2Valid) {
                nums1[resultIdx] = nums2[nums2Idx];
                --nums2Idx;
            }
            --resultIdx;
        }
    }
}
