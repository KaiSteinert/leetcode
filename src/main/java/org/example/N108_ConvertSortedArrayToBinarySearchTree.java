package org.example;

import java.util.Arrays;

public class N108_ConvertSortedArrayToBinarySearchTree {

    /**
     * Given an integer array nums where the elements are sorted in ascending order,
     * convert it to a height-balanced binary search tree.
     *
     * Input [0,1,2,3,4,5]
     * Output [2,1,5,0,null,4,null,null,null,3]
     * Expected [3,1,5,0,2,4]
     *
     * [0,-3,9,-10,null,5]
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int half_length = nums.length / 2;
        return new TreeNode(nums[half_length],
                sortedArrayToBST(Arrays.copyOfRange(nums,  0, half_length)),
                sortedArrayToBST(Arrays.copyOfRange(nums,  half_length + 1, nums.length)));
    }
}

