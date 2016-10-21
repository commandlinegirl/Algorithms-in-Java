package com.commandlinegirl.algorithms.dp;

public class LongestCommonSubstring {

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

    /***
     * Returns (one of) the longest common substring of two strings.
     * Bottom up solution.
     * @param a string a
     * @param b string b
     * @return
     */
    public String findLcSubstringTab(String a, String b) {
        int[][] cache =  new int[a.length() + 1][b.length() + 1];
        int a_longestLastIndex = 0;
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
                    a_longestLastIndex = i;
                }
                else {
                    cache[i][j] = 0;
                }
            }
        }

        char[] longest = new char[result];
        while (a_longestLastIndex > 0) {
            longest[a_longestLastIndex - 1] = a.charAt(a_longestLastIndex - 1);
            a_longestLastIndex--;
        }

        return String.valueOf(longest);
    }

}