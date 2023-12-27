package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class N1_TwoSum {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
     * target. You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * <p>
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * <p>
     * Example 2:
     * Output: [1,2]
     * <p>
     * Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */

    public int[] twoSum(int[] nums, int target) {
        for (int firstIndex : IntStream.range(0, nums.length - 1).toArray()) {
            for (int secondIndex : IntStream.range(1, nums.length).toArray()) {
                if (nums[firstIndex] + nums[secondIndex] == target && firstIndex != secondIndex) {
                    return new int[]{firstIndex, secondIndex};
                }
            }
        }
        return null;
    }

    public int[] twoSumFancy(int[] nums, int target) {
        Map<Integer, Integer> subResults = new HashMap<>();
        for (int index : IntStream.range(0, nums.length).toArray()) {
            int sub = target - nums[index];
            if (subResults.containsKey(sub)) {
                return new int[]{subResults.get(sub), index};
            } else {
                subResults.put(nums[index], index);
            }
        }
        return null;
    }
}
