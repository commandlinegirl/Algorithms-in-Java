package com.commandlinegirl.algorithms.strings;

public class Palindrome {

    /**
     * Returns true is the string is a palindrome, otherwise returns false.
     * @param s string
     * @param i first character
     * @param j last character
     * @return
     */
    public static boolean isPalindrome(String s, int i, int j) {
        return (i >= j) || s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1);
    }

    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }
}