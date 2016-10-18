package com.commandlinegirl.algorithms.dp;

/**
 * Adapted from: http://algorithms.tutorialhorizon.com/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {

    public int lps(String A) {
        char[] chars = A.toCharArray();
        int n = chars.length;
        int[][] p = new int[n][n];
        //p[i][j] - length of palindrome from ith index to jth index
        for(int i = 0; i < n; i++){
            p[i][i] = 1;
        }

        for(int sublen = 2; sublen <= n; sublen++){
            for(int i=0; i <= n - sublen;i++) {
                int j = sublen + i - 1;
                if (sublen == 2 && chars[i]==chars[j]){
                    p[i][j] = 2;
                }
                else if(chars[i]==chars[j]){
                    p[i][j] = p[i+1][j-1]+2;
                }
                else{
                    p[i][j] = Math.max(p[i+1][j],p[i][j-1]);
                }
            }
        }
        printMatrix(p);
        return p[0][p.length-1];

    }

    private void printMatrix(int [][] p){
        for (int i=0;i<p.length;i++){
            for(int j=0;j<p.length;j++){
                System.out.print("  " + p[i][j]);
            }
            System.out.println("");
        }
    }

}