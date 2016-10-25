package com.commandlinegirl.algorithms.dp;

/**
 * Given an array of n positive integers, find the sum of maximum sum subsequence of the given
 * array such that the intgers in the subsequence are sorted in increasing order.
 */
public class MaxSumIncreasingSubsequence {

    public int maxSumIncreasingSubsequence(int[] ar) {
        // cache for storing maxSumIncreasingSubsequence at i
        int[] cache = new int[ar.length];
        int max = 0;
        for (int i = 0; i < ar.length; i++) {
            cache[i] = ar[i];
            for (int j = 0; j < i; j++) {
                if (ar[i] > ar[j])
                    cache[i] = Math.max(cache[i], cache[i] + ar[j]);
            }
            max = Math.max(max, cache[i]);
        }
        return max;
    }
}
