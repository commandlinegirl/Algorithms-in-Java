package com.commandlinegirl.algorithms.leetcode;

/***
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    
    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        if (n > 0)
            cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            int count = cache[i - 1] + cache[i - 2];
            cache[i] = count;
        }
        return cache[n];
    }
}

