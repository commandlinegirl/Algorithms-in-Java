package com.commandlinegirl.algorithms.leetcode;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    /**
     * Using xor properties: a ^ a  = 0 and a ^ 1 = a.
     * Time complexity: O(n)
     * Memory: O(1)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums)
            xor ^= i;
        return xor;
    }
}
