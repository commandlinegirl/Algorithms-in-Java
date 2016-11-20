package com.commandlinegirl.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> li = new ArrayList<>(Arrays.asList(1));
        while (rowIndex > 0) {
            for (int i = li.size() - 1; i > 0; i--) {
                li.set(i, li.get(i - 1) + li.get(i));
            }
            li.add(1);
            rowIndex--;
        }
        return li;
    }

}
