package com.commandlinegirl.algorithms.leetcode;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int maj = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[maj] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                maj = i;
                count = 1;
            }
        }

        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maj] == nums[i])
                count++;
        }
        return (count > nums.length / 2) ? nums[maj] : -1;
    }
}
