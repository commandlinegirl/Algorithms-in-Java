package com.commandlinegirl.algorithms.leetcode;

import java.util.*;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderIterative {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null)
            return vals;
        Stack<TreeNode> s = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode x = s.peek();
            if (x.left != null && !visited.contains(x.left)) {
                s.push(x.left);
                visited.add(x.left);
            } else {
                x = s.pop();
                vals.add(x.val);
                visited.remove(x.left);
                if (x.right != null) {
                    s.push(x.right);
                }
            }
        }
        return vals;
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
