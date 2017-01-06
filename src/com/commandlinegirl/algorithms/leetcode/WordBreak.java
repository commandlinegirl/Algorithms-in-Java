package com.commandlinegirl.algorithms.leetcode;

import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }

        boolean[] wb = new boolean[s.length() + 1];
        wb[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                // if the prefix is true and the current suffix is contained in dict
                // update the wb with current suffix end (will be start for next iteration)
                // wb[start] - was the prefix to current suffix in the dict
                if (wb[start] && wordDict.contains(s.substring(start, end))) {
                    wb[end] = true;
                    break;
                }
            }
        }
        return wb[s.length()];
    }

    public boolean wordBreakRecursive(String s, Set<String> wordDict) {
        int n = s.length();
        if (n == 0) {
            return true;
        }

        for (int i = 1; i <= n; i++) {
            // For each prefix, check word breaking in the suffix
            if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i, n), wordDict))
                return true;
        }
        return false;
    }
}
