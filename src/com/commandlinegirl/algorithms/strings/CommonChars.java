package com.commandlinegirl.algorithms.strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Given two strings, output a string containing common,
 * non-repeating characters from the input strings. */
public class CommonChars {

    private static String getCommonCharsString(String a, String b) {
        Set<Character> setA = new HashSet<>();
        for (char c : a.toCharArray()) {
            setA.add(c);
        }
        
        Set<Character> setB = new HashSet<>();
        for (char c : b.toCharArray()) {
            setB.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iter = setB.iterator();
        while (iter.hasNext()) {
            Character c = iter.next();
            if (setA.contains(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String a = "abcddsa";
        String b = "addxyz";
        System.out.println(getCommonCharsString(a, b));
    }
}
