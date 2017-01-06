package com.commandlinegirl.algorithms.leetcode;

/**
 * Created by kereish on 1/4/17.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char current = strs[0].charAt(i);
            for (String s : strs) {
                if (s.length() <= i || s.charAt(i) != current) {
                    return sb.toString();
                }
            }
            sb.append(current);
        }
        return sb.toString();
    }
}
