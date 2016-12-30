package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int cycle = 2 * numRows - 2;
        for (int i = 0; i < numRows; ++i) {
            for (int j = i; j < s.length(); j = j + cycle) {
                sb.append(s.charAt(j));
                // add second value in cycle
                int second_j = (j - i) + cycle - i;
                if (i != 0 && i != numRows - 1 && second_j < s.length()) {
                    sb.append(s.charAt(second_j));
                }
            }
        }
        return sb.toString();
    }
}
