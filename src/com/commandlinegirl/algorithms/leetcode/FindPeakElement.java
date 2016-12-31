package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/submissions/detail/87344230/
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                return mid;
            }
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] > nums[mid]) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return nums[lo] > nums[hi] ? lo : hi;
    }
}
