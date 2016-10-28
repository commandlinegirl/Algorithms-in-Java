package com.commandlinegirl.algorithms.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        Map<Character, Integer> index = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            Integer curCount = counts.get(cur);
            if (curCount == null) {
                counts.put(cur, 1);
                index.put(cur, i);
            } else {
                counts.put(cur, curCount + 1);
            }
        }
        for (Map.Entry<Character, Integer> e : counts.entrySet()) {
            if (e.getValue() == 1) {
                return index.get(e.getKey());
            }
        }
        return -1;
    }
}
