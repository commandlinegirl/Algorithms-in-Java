package com.commandlinegirl.algorithms.dp;

import com.commandlinegirl.algorithms.strings.Palindrome;

import java.util.Arrays;

/**
 * Given a string, a partitioning of the string is a palindrome partitioning if every
 * substring of the partition is a palindrome. Determine the fewest cuts needed for
 * palindrome partitioning of a given string.
 */
public class PalindromeMinCut {

    private int minCutsRecHelp(String s, int i, int j) {
        if (i == j || Palindrome.isPalindrome(s, i, j))
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++)
            min = Math.min(min, 1 + minCutsRecHelp(s, i, k) + minCutsRecHelp(s, k + 1, j));
        return min;
    }

    public int minCutsRec(String s) {
        return minCutsRecHelp(s, 0, s.length() - 1);
    }

    /**
     * Bottom up dp solution.
     * https://discuss.leetcode.com/topic/2048/my-dp-solution-explanation-and-code/17
     */
    public int minCutsTab(String s) {
        int n = s.length();
        int[] cuts = new int[n]; // minimum number of cuts for s[0..j]
        boolean[][] pals = new boolean[n][n]; // palindrome matrix for strings s[i..j]
        Arrays.fill(cuts, Integer.MAX_VALUE);
        for (int j = 0; j < n; j++) {
            cuts[j] = j;
            pals[j][j] = true;
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 >= j || pals[i + 1][j - 1])) { // check if is palindrome
                    if (i == 0)
                        cuts[j] = 0;
                    else {
                        pals[i][j] = true;
                        cuts[j] = Math.min(cuts[i - 1] + 1, cuts[j]);
                    }
                }
            }
        }

        return cuts[n-1];
    }

}
