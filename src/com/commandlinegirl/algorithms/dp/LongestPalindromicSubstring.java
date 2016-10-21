package com.commandlinegirl.algorithms.dp;

public class LongestPalindromicSubstring {

    /***
     * Code adopted from http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
     */
    public int lpSubstring(String a) {
        int n = a.length();
        if (n == 0)
            return 0;

        boolean[][] p = new boolean[n][n];

        int maxLen = 1;
        for (int i = 0; i < n; i++)
            p[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            if (a.charAt(i) == a.charAt(i + 1)) {
                maxLen = 2;
                p[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (p[i+1][j-1]  // "inner" substring is a palindrome
                        && a.charAt(i) == a.charAt(j)) {
                    p[i][j] = true;
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }

}