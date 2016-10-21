package com.commandlinegirl.algorithms.dp;

public class LongestCommonSubsequence {

    /***
     * Returns the length of the longest common subsequence of two strings.
     * Recursive solution without memoization.
     * @param a string a
     * @param b string b
     * @param m length of string a
     * @param n length of string b
     * @return
     */
    public int lcSubsequenceRec(String a, String b, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (a.charAt(m - 1) == b.charAt(n - 1))
            return 1 + lcSubsequenceRec(a, b, m - 1, n - 1);
        else
            return Math.max(
                    lcSubsequenceRec(a, b, m - 1, n),
                    lcSubsequenceRec(a, b, m, n - 1)
            );
    }

    private int lcSubsequenceRecMem(String a, String b, int m, int n, int[][] cache) {
        if (m == 0 || n == 0)
            return 0;

        if (cache[m][n] > 0)
            return cache[m][n];

        if (a.charAt(m - 1) == b.charAt(n - 1))
            cache[m][n] = 1 + lcSubsequenceRecMem(a, b, m - 1, n - 1, cache);
        else
            cache[m][n] = Math.max(
                    lcSubsequenceRecMem(a, b, m - 1, n, cache),
                    lcSubsequenceRecMem(a, b, m, n - 1, cache)
            );
        return cache[m][n];
    }

    /***
     * Returns the length of the longest common subsequence of two strings.
     * Recursive top down solution with memoization.
     * @param a string a
     * @param b string b
     * @return
     */
    public int lcSubsequenceRecMem(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] cache =  new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                cache[i][j] = -1;
        return lcSubsequenceRecMem(a, b, m, n, cache);
    }

}
