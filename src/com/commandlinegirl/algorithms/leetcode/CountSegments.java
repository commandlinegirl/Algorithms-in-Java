package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 */
public class CountSegments {

    public int countSegments(String s) {
        int count = 0;
        boolean lastWasChar = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                lastWasChar = false;
            }
            else if (!lastWasChar) {
                count++;
                lastWasChar = true;
            }
        }
        return count;
    }

    public int countSegments2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }
}
