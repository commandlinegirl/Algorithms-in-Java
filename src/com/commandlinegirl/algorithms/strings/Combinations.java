package com.commandlinegirl.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

/* Having a string on the input, it returns a list of strings 
 * in which zero or more of the characters of the string are masked
 * with a provided character. For example, for the input 'A.B.C' (dot-separated) 
 * and the masking character 'X' the output will be: 'XBC', 'XXC', 'ABC', 'XXX', etc.
 *
 * It used bitwise operations for better performance.
 */

public class Combinations {

    private static final int limit = 10;

    private static Set<String> createCombinations(String[] tokens, String replacement) {
        if (tokens.length > 10) {
            throw new IllegalArgumentException("Lenght of the input sequence should not exceed 10");
        }
        Set<String> set = new HashSet<String>();
        int l = 1 << tokens.length;
        int i = 0;
        while (i < l) {
            String[] result = tokens.clone();
            StringBuilder sequence = new StringBuilder();
            int m = 1;
            int k = 0;
            while (k < tokens.length) {
                if ((m & i) == m) {
                    result[k] = replacement;
                }
                sequence.append(result[k]);
                m = m << 1;
                k++;
            }
            set.add(sequence.toString());
            i++;
        }
        return set;
    }

    private static String printCombinations(Set<String> set) {
        StringBuilder sequence = new StringBuilder("(");
        boolean first = true;
        for (String s : set) {
               if (!first) {
                    sequence.append(", ");
                }
                sequence.append("\'");
                sequence.append(s.toString());
                sequence.append("\'");
                        first = false;
        }
        sequence.append(")");
        return sequence.toString();
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("A.B.C.D");
        System.out.println(printCombinations(createCombinations("A.B.C.D.E".split("\\."), "X")));
    }

}

