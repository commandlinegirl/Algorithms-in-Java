package com.commandlinegirl.algorithms.dp;

/**
 * Solution to longest increasing subsequence problem
 * using dynamic programming with memoization and tabulation.
 */
public class LongestIncreasingSubsequence {

    public int lisTab(int[] ar) {
        int n = ar.length;
        int max = 0;
        int[] cache = new int[n];

        // for each item i, iterate over elements at indices 0 to i - 1
        // and cache the lis value at i
        for (int i = 0; i < n; i++) {
            cache[i] = 1;
            for (int j = 0; j < i; j++) {
                if (ar[j] < ar[i])
                    cache[i] = Math.max(cache[i], 1 + cache[j]);
            }
            max = Math.max(max, cache[i]);
        }

        return max;
    }

}