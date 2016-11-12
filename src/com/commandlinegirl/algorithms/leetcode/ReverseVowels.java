package com.commandlinegirl.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowels {

    private Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    /**
     * Recursive solution
     * Time complexity: O(n)
     * Memory complexity: O(n + m)
     * n is due to stack usage with each recursive call.
     * m is number of vowels in the alphabet
     * @param s
     * @return
     */
    public String reverseVowels1(String s) {
        char[] ret = s.toCharArray();
        reverseVowels(ret, 0, s.length() - 1);
        return String.valueOf(ret);
    }

    private void reverseVowels(char[] s, int i, int j) {
        if (i >= j)
            return;
        if (vowels.contains(s[i]) && vowels.contains(s[j])) {
            if (s[i] != s[j]) {
                swap(s, i, j);
            }
            reverseVowels(s, i + 1, j - 1);
        }
        else if (vowels.contains(s[i]))
            reverseVowels(s, i, j - 1);
        else if (vowels.contains(s[j]))
            reverseVowels(s, i + 1, j);
        else
            reverseVowels(s, i + 1, j - 1);
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    /**
     * Iterative solution
     * Time complexity: O(n)
     * Memory complexity: O(1) 
     * @param s
     * @return
     */
    public String reverseVowels2(String s) {
        char[] ret = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (!vowels.contains(ret[i])) {
                i++;
                continue;
            }
            if (!vowels.contains(ret[j])) {
                j--;
                continue;
            }
            swap(ret, i, j);
            i++;
            j--;

        }
        return String.valueOf(ret);
    }
}
