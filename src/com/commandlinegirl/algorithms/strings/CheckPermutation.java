package com.commandlinegirl.algorithms.strings;

import java.util.Arrays;

/* Having two strings, check if one is a permutation of the other. 
 * The strings should have different orders and equal size.
 */
public class CheckPermutation {
    
    public static boolean checkPermutation(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input string is null.");
        }
        
        if (a.length() != b.length()) {
            return false;
        }
          
        return sort(a).equals(sort(b));
    
    }
        
    private static String sort(String input) {
        char[] c = input.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    
}
