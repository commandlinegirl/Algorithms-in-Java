package com.commandlinegirl.algorithms.leetcode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
 * v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be
 * a descendant of itself).”
 */
public class LowestCommonAncestorBst {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;

    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
}
