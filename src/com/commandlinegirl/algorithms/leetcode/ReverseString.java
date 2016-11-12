package com.commandlinegirl.algorithms.leetcode;

import java.util.Stack;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    public String reverseStringRecursive(String s) {
        return String.valueOf(reverseRecursive(s.toCharArray(), 0, s.length() - 1));
    }

    private char[] reverseRecursive(char[] s, int i, int j) {
        if (i >= j)
            return s;
        swap(s, i, j);
        return reverseRecursive(s, i + 1, j - 1);
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public String reverseStringQueue(String s) {
        Stack<Character> q = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray())
            q.push(c);
        while (!q.empty())
            sb.append(q.pop());
        return sb.toString();
    }

}
