package com.commandlinegirl.algorithms.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Recursive implementation of algorithm generating permutations
 * of a string. Repeating characters are treated as a one char, ie. 
 * from "abb" input, the output list contains only: "ab", "ba" */ 
public class Permutation {

    /* Main algorithm */
    private static List<String> generatePermutations(String chars) {
        List<String> result = new ArrayList<>();
        if (chars.length() <= 1) {
            result.add(chars);
            return result;
        }

        for (char c : chars.toCharArray()) {
            String charlessStr = chars.replace(String.valueOf(c), "");
            List<String> permutations = generatePermutations(charlessStr);
            for (String p : permutations) {
                result.add(c + p);
            }
        }
        return result;
    }
    
    public static List<String> permutate(String chars) {
        return generatePermutations(uniquify(chars));
    }
    
    private static String uniquify(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(new Character(c));
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }
        return sb.toString();
    }
}
