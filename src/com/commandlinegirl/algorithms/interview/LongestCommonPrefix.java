package com.commandlinegirl.algorithms.interview;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(List<String> a) {
        if (a == null || a.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        String s = a.get(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (String r : a) {
                if (r.length() < i+1 || r.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
