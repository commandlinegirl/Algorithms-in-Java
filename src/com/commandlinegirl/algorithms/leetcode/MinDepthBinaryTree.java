package com.commandlinegirl.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinDepthBinaryTree {

    /* Recursive */
    public int minDepthRec(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return 1 + minDepthRec(root.right);
        if (root.right == null)
            return 1 + minDepthRec(root.left);
        else
            return 1 + Math.min(minDepthRec(root.left), minDepthRec(root.right));
    }

    /* Iterative */
    public int minDepthIter(TreeNode root) {
        if (root == null)
            return 0;

        int h = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int numAtLevel = q.size();
            while (numAtLevel > 0) {
                TreeNode n = q.remove();
                if (n.left == null && n.right == null) {
                    return h;
                }
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
                numAtLevel--;
            }
            h++;
        }
        return h;
    }
}