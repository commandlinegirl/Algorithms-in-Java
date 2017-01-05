package com.commandlinegirl.algorithms.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWords {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
            }
            else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        stack.push(sb.toString());
        sb.setLength(0);
        boolean first = true;
        while (!stack.empty()) {
            if (first) {
                sb.append(" ");
            }
            sb.append(stack.pop());
            first = false;
        }
        return sb.toString();
    }
}
