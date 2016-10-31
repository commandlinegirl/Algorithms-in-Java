package com.commandlinegirl.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstringHashSet(String s) {
        int ls = 0;
        int start = 0;
        int end = 0;
        Set<Character> visited = new HashSet<>();
        while (end < s.length()) {
            if (visited.contains(s.charAt(end))) {
                ls = Math.max(ls, visited.size());
                while (start < end && s.charAt(start) != s.charAt(end)) {
                    visited.remove(s.charAt(start)); // remove all characters up to the one that is repeated at this point
                    start++;
                }
            }
            else {
                visited.add(s.charAt(end));
            }
            end++;
        }
        ls = Math.max(ls, visited.size());

        return ls;
    }

    public int lengthOfLongestSubstringHashMap(String s) {
        int ls = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> visited = new HashMap<>();
        while (end < s.length()) {
            if (visited.get(s.charAt(end)) != null) {
                ls = Math.max(ls, visited.size());
                // remove all characters up to the one that is repeated at this point
                for (int i = start; i < visited.get(s.charAt(end)); i++) {
                    visited.remove(s.charAt(start));
                    start++;
                }

            }
            else {
                visited.put(s.charAt(end), end);
            }
            end++;
        }
        ls = Math.max(ls, visited.size());
        return ls;
    }
}
