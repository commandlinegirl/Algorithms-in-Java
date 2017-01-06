package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (n >= 0 && m >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[j--] = nums1[m--];
            }
            else {
                nums1[j--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[j--] = nums2[n--];
        }
    }
}
