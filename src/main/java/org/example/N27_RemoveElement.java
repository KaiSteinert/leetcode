package org.example;

import static java.util.Objects.isNull;

public class N27_RemoveElement {
    /**
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
     * <p>
     * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
     * <p>
     * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.<br>
     * Return k.
     * <p>
     * Custom Judge:
     * <p>
     * The judge will test your solution with the following code:
     * <p>
     * int[] nums = [...]; // Input array<br>
     * int val = ...; // Value to remove<br>
     * int[] expectedNums = [...]; // The expected answer with correct length.<br>
     * // It is sorted with no values equaling val.
     * <p>
     * int k = removeElement(nums, val); // Calls your implementation
     * <p>
     * assert k == expectedNums.length;<br>
     * sort(nums, 0, k); // Sort the first k elements of nums<br>
     * for (int i = 0; i < actualLength; i++) {<br>
     * assert nums[i] == expectedNums[i];<br>
     * }
     * <p>
     * If all assertions pass, then your solution will be accepted.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,2,3], val = 3<br>
     * Output: 2, nums = [2,2,_,_]<br>
     * Explanation: Your function should return k = 2, with the first two elements of nums being 2.<br>
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [0,1,2,2,3,0,4,2], val = 2<br>
     * Output: 5, nums = [0,1,4,0,3,_,_,_]<br>
     * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.<br>
     * Note that the five elements can be returned in any order.<br>
     * It does not matter what you leave beyond the returned k (hence they are underscores).<br>
     */
    private static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }

    private static void swapElements(int[] nums, int idx, int idxDesc) {
        int temp = nums[idxDesc];
        nums[idxDesc] = nums[idx];
        nums[idx] = temp;
    }

    public static int removeElement(int[] nums, int val) {
        if (isNull(nums) || isEmpty(nums)) {
            return 0;
        }
        int idxDesc = nums.length;
        for (int idx=0; idx<nums.length; idx++){
            if (nums[idx] == val) {
                while (idxDesc>idx) {
                    idxDesc--;
                    if (nums[idxDesc] != val) {
                        break;
                    }
                }
                swapElements(nums, idx, idxDesc);
            }
        }

        return idxDesc;
    }
}