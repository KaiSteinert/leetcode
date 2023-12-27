package org.example;

import static java.util.Objects.isNull;

public class N26_RemoveDublicatesFromSortedArray {
    /**
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
     * <p>
     * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     * <p>
     * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.<br>
     * Return k.
     * <p>
     * Custom Judge:
     * <p>
     * The judge will test your solution with the following code:
     * <p>
     * int[] nums = [...]; // Input array<br>
     * int[] expectedNums = [...]; // The expected answer with correct length
     * <p>
     * int k = removeDuplicates(nums); // Calls your implementation
     * <p>
     * assert k == expectedNums.length;<br>
     * for (int i = 0; i < k; i++) {<br>
     * assert nums[i] == expectedNums[i];<br>
     * }
     * <p>
     * If all assertions pass, then your solution will be accepted.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,1,2]<br>
     * Output: 2, nums = [1,2,_]<br>
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.<br>
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]<br>
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]<br>
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.<br>
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    private static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }

    public static int removeDuplicates(int[] nums) {
        if (isNull(nums) || isEmpty(nums)) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int swapPosition = 0;
        for (int idx=1; idx<nums.length; idx++) {
            if (nums[swapPosition] != nums[idx]) {
                swapPosition++;
                nums[swapPosition] = nums[idx];
            }
        }
        return ++swapPosition;
    }
}
