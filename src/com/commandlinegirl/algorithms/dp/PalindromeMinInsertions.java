package com.commandlinegirl.algorithms.dp;

/***
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
 */
public class PalindromeMinInsertions {

    public int insertsRec(String s, int i, int j) {
        if (i >= j || (j - i == 1 && s.charAt(i) == s.charAt(j)))
            return 0;

        if (s.charAt(i) == s.charAt(j))
            return insertsRec(s, i + 1, j - 1);
        else
            return 1 + Math.min(insertsRec(s, i, j - 1), insertsRec(s, i + 1, j));
    }
}
