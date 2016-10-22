package com.commandlinegirl.algorithms.strings;

public class Palindrome {

    /**
     * Returns true is the substring s[i:j] is a palindrome, otherwise returns false.
     * @param s string
     * @param i first index in the string
     * @param j last index in the string
     * @return
     */
    public static boolean isPalindrome(String s, int i, int j) {
        return (i >= j) || s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1);
    }

    /**
     * Returns true is the string is a palindrome, otherwise returns false.
     * @param s string
     * @return
     */
    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }
}