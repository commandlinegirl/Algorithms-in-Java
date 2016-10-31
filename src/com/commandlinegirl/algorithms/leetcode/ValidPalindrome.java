package com.commandlinegirl.algorithms.leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        boolean ret = true;
        String t = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] c = t.toCharArray();
        int i = 0;
        int j = c.length - 1;

        while (i < j) {
            if (c[i] != c[j])
                return false;
            i++;
            j--;
        }
        return ret;
    }
}
