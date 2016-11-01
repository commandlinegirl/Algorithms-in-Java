package com.commandlinegirl.algorithms.leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int digits = digits(x);
        int div = (int) Math.pow(10, digits - 1);

        while (x != 0) {
            int l = x / div;
            int r = x % 10;

            if (l != r)
                return false;
            x %= div;
            x /= 10;
            div /= 100;
        }
        return true;
    }

    private int digits(int n) {
        return (int) Math.floor(Math.log(n)/ Math.log(10)) + 1;
    }


//    private boolean isPalindromeHelp(int n, int digits) {
//        if (n == 0)
//            return true;
//        if (n < 10)
//            return true;
//        int y = n % bullNumber(digits);
//        if (y % 10 != 0)
//            return false;
//        else
//            return isPalindromeHelp(y % 10, n - 2);
//    }
//
//    private int bullNumber(int n) {
//        return (int) Math.pow(10, n -1) + 1;
//    }
//
//    public boolean isPalindrome2(int x) {
//        return isPalindromeHelp(x, digits(x));
//    }
}
