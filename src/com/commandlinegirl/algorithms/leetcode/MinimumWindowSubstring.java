package com.commandlinegirl.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int start = 0, end = 0;
        int counter = t.length(); // number of t characters in s
        int min_so_far = Integer.MAX_VALUE;
        int head = 0;
        Map<Character, Integer> tchars = new HashMap<>();
        for (char c : t.toCharArray())
            tchars.put(c, tchars.getOrDefault(c, 0) + 1);

        while (end < s.length()) {
            if (tchars.get(s.charAt(end)) > 0) {
                counter--;
            }
            tchars.put(s.charAt(end), tchars.get(s.charAt(end)) - 1);
            end++;

            // A valid window is found; save its size and head,
            // then move start to find a smaller window
            while (counter == 0) {
                if (end - start < min_so_far) {
                    min_so_far = end - start;
                    head = start;
                }

                tchars.put(s.charAt(start), tchars.get(s.charAt(start)) + 1);
                if (tchars.get(s.charAt(start)) > 0) {
                    counter++;
                }
                start++;
            }
        }

        return min_so_far == Integer.MAX_VALUE ? "" : s.substring(head, head + min_so_far);
    }
}
