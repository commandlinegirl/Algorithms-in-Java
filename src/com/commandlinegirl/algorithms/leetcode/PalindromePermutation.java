package com.commandlinegirl.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/palindrome-permutation/
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }

}
