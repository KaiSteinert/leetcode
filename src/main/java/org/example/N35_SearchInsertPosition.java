package org.example;

import static java.util.Objects.isNull;

public class N35_SearchInsertPosition {
    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * <p>
     * You must write an algorithm with O(log n) runtime complexity.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,3,5,6], target = 5<br>
     * Output: 2
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [1,3,5,6], target = 2<br>
     * Output: 1
     * <p>
     * Example 3:
     * <p>
     * Input: nums = [1,3,5,6], target = 7<br>
     * Output: 4
     */
    private static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }

    private static int searchInsertRecursive(int[] nums, int target, int lowIdx, int highIdx) {
        int halfWayPoint = ((highIdx - lowIdx) / 2) + lowIdx;
        if (halfWayPoint == lowIdx) {
            return ++lowIdx;
        }
        if (halfWayPoint == highIdx) {
            return highIdx;
        }
        if (nums[halfWayPoint] < target) {
            return searchInsertRecursive(nums, target, halfWayPoint, highIdx);
        }
        if (nums[halfWayPoint] > target) {
            return searchInsertRecursive(nums, target, lowIdx, halfWayPoint);
        }
        if (nums[halfWayPoint] == target) {
            return halfWayPoint;
        }
        return -1;
    }
    public static int searchInsert(int[] nums, int target) {
        if (isNull(nums) || isEmpty(nums)) {
            return 0;
        }
        if (nums[0] >= target) {
            return 0;
        }
        return searchInsertRecursive(nums, target, 0, nums.length);
    }
}
