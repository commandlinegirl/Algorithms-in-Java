package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInArray {

    private int partition(int[] nums, int lo, int hi, int k) {
        int i = lo;
        int p = nums[hi];
        for (int j = lo; j < hi; j++) {
            if (nums[j] > p) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, hi);
        return i;
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {
        if (lo == hi) {
            return nums[lo];
        }

        int p = partition(nums, lo, hi, k);
        if (p == k) {
            return nums[p];
        }
        else if (k < p) {
            return quickSelect(nums, lo, p - 1, k);
        }
        else {
            return quickSelect(nums, p + 1, hi, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private void swap(int[] ar, int a, int b) {
        int tmp = ar[a];
        ar[a] = ar[b];
        ar[b] = tmp;
    }
}
