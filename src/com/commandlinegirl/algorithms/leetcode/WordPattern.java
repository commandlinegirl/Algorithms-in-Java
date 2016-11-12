package com.commandlinegirl.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

    /**
     * Time complexity: O(n) where n is the length of the pattern
     * Memory complexity: O(n + m) where n is alphabet length
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> mc = new HashMap<>();
        Map<String, Integer> ms = new HashMap<>();
        String str2 = str.trim();
        String[] wordList = str2.split(" ");
        if (wordList.length != pattern.length())
            return false;

        Integer i = 0;
        while (i < pattern.length()) {
            if (mc.put(pattern.charAt(i), i) != ms.put(wordList[i], i))
                return false;
            i++;
        }
        return true;
    }

}
