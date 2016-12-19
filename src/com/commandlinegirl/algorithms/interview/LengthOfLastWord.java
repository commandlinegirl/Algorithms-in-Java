package com.commandlinegirl.algorithms.interview;

/**
 * https://www.interviewbit.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(final String a) {
        int j = a.length() - 1;
        boolean encounteredChar = false;
        int count = 0;
        while (j >= 0) {
            if (a.charAt(j) == ' ' && encounteredChar) {
                return count;
            }
            if (a.charAt(j) != ' ') {
                encounteredChar = true;
                count++;
            }
            j--;
        }
        return count;
    }
}
