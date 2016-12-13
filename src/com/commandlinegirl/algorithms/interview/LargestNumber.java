package com.commandlinegirl.algorithms.interview;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  https://www.interviewbit.com/problems/largest-number/
 */
public class LargestNumber {

    public String largestNumber(final List<Integer> a) {
        List<String> s = a.stream().map(String::valueOf).collect(Collectors.toList());

        Collections.sort(s, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String r1 = a + b;
                String r2 = b + a;
                return r2.compareTo(r1);
            }
        });

        if (s.get(0).charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String i : s) {
            sb.append(i);
        }
        return sb.toString();
    }
}
