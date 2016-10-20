package com.commandlinegirl.algorithms.dp;

public class LongestPalindromicSubsequence {

    private int lpsRecHelp(String a, int s, int e, int[][] cache) {
        int strLen = e - s + 1;
        if (strLen <= 1)
            return strLen;

        if (cache[s][e] > 0) {
            return cache[s][e];
        }

        if (a.charAt(s) == a.charAt(e))
            cache[s][e] = 2 + lpsRecHelp(a, s + 1, e - 1, cache);
        else
            cache[s][e] = Math.max(lpsRecHelp(a, s + 1, e, cache), lpsRecHelp(a, s, e -1, cache));
        return cache[s][e];
    }

    /***
     * Returns the length of a longest palindromic subsequence in a string
     * Recursive implementation with memoization.
     */
    public int lpsRec(String a, int s, int e) {
        int[][] cache =  new int[e+1][e+1];
        for (int i = 0; i < e; i++)
            for (int j = 0; j < e; j++)
                cache[i][j] = -1;
        return lpsRecHelp(a, s, e, cache);
    }


    /***
     * Returns the length of a longest palindromic subsequence in a string
     * Table bottom-up implementation. Adapted from:
     * http://algorithms.tutorialhorizon.com/longest-palindromic-subsequence/
     */
    public int lps(String A) {
        char[] chars = A.toCharArray();
        int n = chars.length;
        int[][] p = new int[n][n];
        //p[i][j] - length of palindrome from ith index to jth index
        for(int i = 0; i < n; i++){
            p[i][i] = 1;
        }

        for(int sublen = 2; sublen <= n; sublen++){
            for(int i = 0; i <= n - sublen;i++) {
                int j = sublen + i - 1;
                if (sublen == 2 && chars[i]==chars[j]){
                    p[i][j] = 2;
                }
                else if(chars[i]==chars[j]){
                    p[i][j] = 2 + p[i + 1][j - 1];
                }
                else{
                    p[i][j] = Math.max(p[i + 1][j], p[i][j - 1]);
                }
            }
        }
        printMatrix(p);
        return p[0][p.length-1];

    }

    private void printMatrix(int [][] p) {
        for (int i=0;i<p.length;i++) {
            for(int j=0;j<p.length;j++)
                System.out.print("  " + p[i][j]);
            System.out.println("");
        }
    }

}