package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    /**
     * Time complexity: (|t| + |s|)
     * Memory: O(size of the alphabet)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s==null || t==null || s.length()!=t.length())
            return false;

        int[] counts = new int[25];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int i : counts) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
