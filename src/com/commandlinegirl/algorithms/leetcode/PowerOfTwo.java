package com.commandlinegirl.algorithms.leetcode;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerOfTwo {

    /**
     * Time complexity: O(1).
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
