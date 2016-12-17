package com.commandlinegirl.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flip-game/
 */
public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        char[] cs = s.toCharArray();
        while (i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                cs[i] = '-';
                cs[i + 1] = '-';
                ret.add(new String(cs));
                cs[i] = '+';
                cs[i + 1] = '+';
            }
            i++;
        }
        return ret;
    }
}
