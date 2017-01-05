package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaxiumumSumSubarray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int max_ending_here = nums[0];
        for (int i = 1; i < n; i++) {
            max_ending_here = Math.max(max_ending_here + nums[i], nums[i]);
            max = Math.max(max, max_ending_here);
        }
        return max;
    }
}
