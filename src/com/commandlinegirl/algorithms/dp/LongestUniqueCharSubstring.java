package com.commandlinegirl.algorithms.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestUniqueCharSubstring {


    /**
     * Returns the length of the longest substring with non-repeating characters.
     * @param s input string
     * @return
     */
    public int longestUniqueSubstring(String s) {
        int ls = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> visited = new HashMap<>();
        while (end < s.length()) {
            if (visited.get(s.charAt(end)) != null) {
                ls = Math.max(ls, visited.size());
                // remove all characters up to the one that is repeated (ie. equal to the one at end)
                int prevCharIndex = visited.get(s.charAt(end));
                for (int i = start; i <= prevCharIndex; i++) {
                    visited.remove(s.charAt(start));
                    start++;
                }
            }
            visited.put(s.charAt(end), end);
            end++;
        }
        ls = Math.max(ls, visited.size());
        return ls;
    }


}
