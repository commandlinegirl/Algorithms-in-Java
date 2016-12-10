package com.commandlinegirl.algorithms.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/group-shifted-strings/
 */
public class GroupShiftedStrings {

    public class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<String, List<String>> m = new HashMap<>();
            for (String s : strings) {
                if (s.length() != 0) {
                    int offset = (s.charAt(0) - '0') % 97; // or % 'a'
                    StringBuilder sb = new StringBuilder();
                    for (char c : s.toCharArray())
                        sb.append((char) (c - offset) % 26);
                    String representative = sb.toString();

                    if (m.containsKey(representative))
                        m.get(representative).add(s);
                    else
                        m.put(representative, new ArrayList<>(Arrays.asList(s)));
                }
                else {
                    if (m.containsKey(""))
                        m.get("").add(s);
                    else
                        m.put("", new ArrayList<>(Arrays.asList("")));
                }
            }
            return new ArrayList(m.values());
        }
    }
}
