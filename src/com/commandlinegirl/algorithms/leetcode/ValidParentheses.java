package com.commandlinegirl.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    private Map<Character, Character> openings = new HashMap<>();
    {
        openings.put('(', ')');
        openings.put('{', '}');
        openings.put('[', ']');
    }

    /**
     * Iterative solution using a stack.
     * Time complexity: O(|s|)
     * Time complexity: O(|alphabet of parentheses|)
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return true;

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (openings.containsKey(c)) {
                stack.push(c);
            } else if (stack.empty() || openings.get(stack.pop()) != c) {
                return false;
            }
            i++;
        }
        return stack.empty();
    }
}
