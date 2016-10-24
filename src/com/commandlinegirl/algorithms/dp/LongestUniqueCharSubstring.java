package com.commandlinegirl.algorithms.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestUniqueCharSubstring {

    private int longestUniqueSubstringRec(String ar, int j) {
        if (j == 0)
            return 1;

        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < j; i++) {
            if (!set.contains(ar.charAt(i))) {
                max++;
                set.add(ar.charAt(i));
            } else {
                continue;
            }
        }
        return Math.max(max, longestUniqueSubstringRec(ar, j - 1));
    }

    /**
     * Returns the length of the longest substring with non-repeating characters.
     * Recursive solution with O(n^2) time complexity.
     * @param s input string
     * @return
     */
    public int longestUniqueSubstringRec(String s) {
        return longestUniqueSubstringRec(s, s.length() - 1);
    }

    /**
     * Returns the length of the longest substring with non-repeating characters.
     * Bottom up solution
     * @param s input string
     * @return
     */
    public int longestUniqueSubstringTab(String s) {
        //the last indexes of already visited characters
        Map<Character, Integer> lastIndex = new HashMap<>();
        int lus = 0;
        return lus;
    }


}
