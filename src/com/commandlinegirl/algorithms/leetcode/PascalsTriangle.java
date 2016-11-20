package com.commandlinegirl.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if (numRows == 0)
                return result;
            result.add(new ArrayList<>(Arrays.asList(1)));
            while (numRows > 1) {
                List<Integer> prev = result.get(result.size() - 1);
                List<Integer> current = new ArrayList<>();
                current.add(1);
                for (int i = 1; i < prev.size(); i++) {
                    current.add(prev.get(i - 1) + prev.get(i));
                }
                current.add(1);
                result.add(current);
                numRows--;
            }
            return result;
        }
}
