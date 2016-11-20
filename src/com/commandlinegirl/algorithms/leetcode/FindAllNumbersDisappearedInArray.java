package com.commandlinegirl.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int el = nums[Math.abs(nums[i]) - 1];
            if (el > 0) {
                nums[Math.abs(nums[i]) - 1] = - el;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                li.add(i + 1);
        }
        return li;
    }
}
