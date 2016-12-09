package com.commandlinegirl.algorithms.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // position, number
        int i = 0;
        while (i < nums.length) {
            int complement = target - nums[i];
            if (map.get(complement) != null) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
            i++;
        }
        return null;
    }
}
