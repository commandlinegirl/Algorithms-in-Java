package com.commandlinegirl.algorithms.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequence {

    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            q.add(e);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Map.Entry<Character, Integer> e = q.poll();
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }

        return sb.toString();
    }
}
