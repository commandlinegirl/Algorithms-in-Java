package com.commandlinegirl.algorithms.dp;


import java.util.Arrays;

public class Stairs {

    /***
     * Returns the number of ways a person can jump n steps of stairs
     * using 1, 2, .. m steps. Top down dp solution.
     * @param n total number of steps to jump over
     * @param m the highest number of steps that can be jumped at once
     * @return
     */
    public int jumpsTopDown(int n, int m) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return jumpsTopDownHelp(n, m, cache);
    }

    private int jumpsTopDownHelp(int n, int m, int[] cache) {
        if (n == 0) return 1;

        if (cache[n] > -1)
            return cache[n];

        cache[n] = 0;
        for (int i = 1; i <= m && i <= n; i++)
            cache[n] += jumpsTopDownHelp(n - i, m, cache);

        return cache[n];
    }

    /***
     * Returns the number of ways a person can jump n steps of stairs
     * using 1, 2, .. m steps. Bottom up dp solution.
     * @param n total number of steps to jump over
     * @param m the highest number of steps that can be jumped at once
     * @return
     */
    public int jumpsBottomUp(int n, int m) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            int res = 0;
            for (int j = 1; j <= m && j <= i; j++)
                res += cache[i - j];
            cache[i] = res;
        }
        return cache[n];
    }
}
