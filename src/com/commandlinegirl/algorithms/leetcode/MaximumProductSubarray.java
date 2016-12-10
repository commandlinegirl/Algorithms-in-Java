package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int max_ending_here = nums[0];
        int min_ending_here = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                max_ending_here = Math.max(max_ending_here * nums[i], nums[i]);
                min_ending_here = Math.min(min_ending_here * nums[i], nums[i]);
            }
            else {
                // min will now be max, if larger then current max
                int temp = max_ending_here;
                max_ending_here = Math.max(min_ending_here * nums[i], nums[i]);
                min_ending_here = Math.min(temp * nums[i], nums[i]);
            }
            max = Math.max(max, max_ending_here);
        }

        return max;
    }

}
