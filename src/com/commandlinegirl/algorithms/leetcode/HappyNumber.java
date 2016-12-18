package com.commandlinegirl.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            n = getSumOfSquares(n);
            if (n == 1)
                return true;
        }
        return false;
    }

    public static boolean isHappy2(int n) {
        int slow = n;
        int fast = n;
        while (slow > 0) {
            slow = getSumOfSquares(slow);
            if (slow == 1)
                return true;
            fast = getSumOfSquares(getSumOfSquares(fast));
            if (fast == 1)
                return true;
            if (slow == fast)
                return false;
        }
        return false;
    }


    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String... args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy2(19));
        System.out.println(isHappy(17));
        System.out.println(isHappy2(17));
    }
}
