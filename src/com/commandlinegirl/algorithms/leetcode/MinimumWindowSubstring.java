package com.commandlinegirl.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int start = 0, end = 0;
        int counter = t.length();
        int min_so_far = Integer.MAX_VALUE;
        int min_head = 0;
        Map<Character, Integer> tchars = new HashMap<>();
        for (char c : t.toCharArray())
            tchars.put(c, tchars.getOrDefault(c, 0) + 1);

        while (end < s.length()) {
            if (tchars.getOrDefault(s.charAt(end), 0) > 0) {
                counter--;
            }
            tchars.put(s.charAt(end), tchars.getOrDefault(s.charAt(end), 0) - 1);
            end++;

            while (counter == 0) {
                if (end - start < min_so_far) {
                    min_so_far = end - start;
                    min_head = start;
                }
                tchars.put(s.charAt(start), tchars.get(s.charAt(start)) + 1);
                if (tchars.get(s.charAt(start)) > 0) {
                    counter++;   // make it invalid
                }
                start++;
            }
        }
        return min_so_far == Integer.MAX_VALUE ? "" : s.substring(min_head, min_head + min_so_far);
    }
}
