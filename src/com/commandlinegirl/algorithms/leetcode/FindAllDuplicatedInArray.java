package com.commandlinegirl.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatedInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int el = nums[Math.abs(nums[i])  - 1];
            if (el > 0) {
                nums[Math.abs(nums[i]) - 1] = - el;
            }
            else {
                li.add(Math.abs(nums[i]));
            }
        }
        return li;
    }
}
