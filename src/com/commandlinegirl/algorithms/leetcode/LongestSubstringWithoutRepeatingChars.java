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

    /**
     * The hashmap stores the index of the char so that when the char is spotted
     * second time, all the chars up to that index can be removed from the hashmap.
     * Time complexity: O(n), at most each char will be visited 2 times
     * Memory complexity: O(min(m,n)), where m is the size of the alphabet
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
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

    public int lengthOfLongestSubstring2(String s) {
        int end = 0;
        int max = 0;
        Set<Character> visited = new HashSet<>();
        while (end < s.length()) {
            if (!visited.contains(s.charAt(end))) {
                visited.add(s.charAt(end));
                max = Math.max(max, visited.size());
                end++;
            }
            else {
                visited.remove(s.charAt(end));
            }

        }

        return max;
    }
}
