package com.commandlinegirl.algorithms.leetcode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthBinaryTree {

    public int maxDepthRec(TreeNode root) {
        if (root == null)
            return 0;
        int maxLeft = maxDepthRec(root.left);
        int maxRight = maxDepthRec(root.right);
        return 1 + Math.max(maxLeft, maxRight);
    }
}
