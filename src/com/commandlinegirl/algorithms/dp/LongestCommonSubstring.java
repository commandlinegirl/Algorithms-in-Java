package com.commandlinegirl.algorithms.dp;

public class LongestCommonSubstring {

    /***
     * Returns the length of the longest common substring of two strings.
     * Recursive solution without memoization.
     * @param a string a
     * @param b string b
     * @param m length of string a
     * @param n length of string b
     * @return
     */
    public int lcSubstringRec(String a, String b, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (a.charAt(m - 1) == b.charAt(n - 1))
            return 1 + lcSubstringRec(a, b, m - 1, n - 1);
        else
            return Math.max(
                    lcSubstringRec(a, b, m - 1, n),
                    lcSubstringRec(a, b, m, n - 1)
            );
    }

    private int lcSubstringRecMem(String a, String b, int m, int n, int[][] cache) {
        if (m == 0 || n == 0)
            return 0;

        if (cache[m][n] > 0)
            return cache[m][n];

        if (a.charAt(m - 1) == b.charAt(n - 1))
            cache[m][n] = 1 + lcSubstringRecMem(a, b, m - 1, n - 1, cache);
        else
            cache[m][n] = Math.max(
                    lcSubstringRecMem(a, b, m - 1, n, cache),
                    lcSubstringRecMem(a, b, m, n - 1, cache)
            );
        return cache[m][n];
    }

    /***
     * Returns the length of the longest common substring of two strings.
     * Recursive top down solution with memoization.
     * @param a string a
     * @param b string b
     * @return
     */
    public int lcSubstringRecMem(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] cache =  new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                cache[i][j] = -1;
        return lcSubstringRecMem(a, b, m, n, cache);
    }

    /***
     * Returns the length of the longest common substring of two strings.
     * Bottom up solution.
     * @param a string a
     * @param b string b
     * @return
     */
    public int lcSubstringTab(String a, String b) {
        int[][] cache =  new int[a.length() + 1][b.length() + 1];
        int result = 0;
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                // one of the strings is empty
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                }
                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                    result = Math.max(result, cache[i][j]);
                }
                else {
                    cache[i][j] = 0;
                }
            }
        }
        return result;
    }
}