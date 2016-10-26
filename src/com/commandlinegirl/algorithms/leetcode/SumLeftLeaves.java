package com.commandlinegirl.algorithms.leetcode;

/**
 * Find the sum of all left leaves in a given binary tree.
 */
public class SumLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int currentSum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            currentSum = root.left.val;
        return currentSum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
