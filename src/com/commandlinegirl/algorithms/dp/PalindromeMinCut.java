package com.commandlinegirl.algorithms.dp;

import com.commandlinegirl.algorithms.strings.Palindrome;

public class PalindromeMinCut {

    private int minCutsRecHelp(String s, int i, int j) {
        if (i == j || Palindrome.isPalindrome(s, i, j))
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, 1 + minCutsRecHelp(s, i, k) + minCutsRecHelp(s, k + 1, j));
        }
        return min;
    }

    public int minCutsRec(String s) {
        return minCutsRecHelp(s, 0, s.length() - 1);
    }


}
