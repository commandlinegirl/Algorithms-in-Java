package com.commandlinegirl.algorithms.strings;

/* Implement an algorithm to determine if a string has all unique characters
 * without using an additional data structure. 
 * 
 * An average O(nlogn) solution is it to sort with quicksort in place and
 * compare two consecutive characters.
 * 
 * The solution below is O(n2) but doesn't take additional space.
 * 
 */
public class UniqueChars {

    public static boolean areCharactersUnique(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string is null.");
        }
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            int j = i + 1;
            while (j < str.length()) {
                if ((c ^ str.charAt(j)) == 0) {
                    return false;
                }
                j++;
            }
            i++;
        }
        return true;
    }

}
