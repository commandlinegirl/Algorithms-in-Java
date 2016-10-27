package com.commandlinegirl.algorithms.leetcode;

/**
 * Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedArrayToBst {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int lo = 0;
        int hi = nums.length - 1;
        return sortedArrayToBST(nums, lo, hi);
    }

    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (hi - lo) / 2 + lo;
        TreeNode root = create(nums[mid]);
        root.left = sortedArrayToBST(nums, lo, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, hi);
        return root;
    }

    private TreeNode create(int val) {
        return new TreeNode(val);
    }

}
