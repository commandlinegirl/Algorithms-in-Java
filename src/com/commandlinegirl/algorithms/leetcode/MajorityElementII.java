package com.commandlinegirl.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.programcreek.com/2014/07/leetcode-majority-element-ii-java/
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int n1 = 0, n2 = 0;
        int c1 = 0, c2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[n1] == nums[i]) {
                c1++;
            }
            else if (nums[n2] == nums[i]) {
                c2++;
            }
            else if (c1 == 0) {
                c1 = 1;
                n1 = i;
            }
            else if (c2 == 0) {
                c2 = 1;
                n2 = i;
            }
            else {
                c1--;
                c2--;
            }
        }

        c1 = c2 = 0;

        for(int i: nums){
            if (i == nums[n1]) {
                c1++;
            } else if (i == nums[n2]){
                c2++;
            }
        }

        if (c1 > nums.length/3)
            result.add(nums[n1]);
        if (c2 > nums.length/3)
            result.add(nums[n2]);

        return result;
    }



}
