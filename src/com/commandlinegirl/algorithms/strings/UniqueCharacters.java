package com.commandlinegirl.algorithms.strings;

/* Implement an algorithm to determine if a string has all unique characters
 * without using a. additional data structure. 
 * 
 * The solution uses a bit vector, the fact that a ^ a = 0.
 * 
 */
public class UniqueCharacters {

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
