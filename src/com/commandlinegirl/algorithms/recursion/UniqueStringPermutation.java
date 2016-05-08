package com.commandlinegirl.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UniqueStringPermutation {

    public static List<String> permutate(String in) {

        if (in == null)
            return new ArrayList<>();

        List<String> results = new ArrayList<>();

        if (in.length() == 0) {
            results.add("");
            return results;
        }

        Character c = in.charAt(0);
        String rest = in.substring(1);
        List<String> perms = permutate(rest);
        for (String s : perms) {
            results.addAll(insertAtAllPositions(s, c));
        }

        return results;
    }

    public static List<String> permutate2(String in) {

        List<String> results = new ArrayList<>();
        if (in.length() == 0) {
            results.add("");
            return results;
        }

        for (int i = 0; i < in.length(); i++) {
            Character c = in.charAt(i);
            String pref = in.substring(0, i);
            String suff = in.substring(i + 1);
            List<String> perms = permutate(pref + suff);
            for (String s : perms) {
                results.add(c + s);
            }
        }

        return results;
    }

    private static List<String> insertAtAllPositions(String inString, Character c) {

        List<String> strings = new ArrayList<>();
        for (int i = 0; i <= inString.length(); i++) {
            String pref = inString.substring(0, i);
            String suff = inString.substring(i);
            strings.add(pref + c + suff);
        }
        return strings;
    }

    private static void printStrings(List<String> list) {
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main(String... args) {
        String in = "abcd";
        printStrings(permutate(in));
        printStrings(permutate2(in));
    }
}
