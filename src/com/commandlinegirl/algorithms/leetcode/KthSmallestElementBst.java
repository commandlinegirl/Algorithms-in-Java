package com.commandlinegirl.algorithms.leetcode;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementBst {

    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        pushLeftNodes(stack, root);
        while (!stack.empty()) {
            TreeNode tn = stack.pop();
            if (k == 1) {
                return tn.val;
            }
            k--;
            pushLeftNodes(stack, tn.right);
        }
        return -1;
    }

    private void pushLeftNodes(Stack<TreeNode> stack, TreeNode n) {
        while (n != null) {
            stack.push(n);
            n = n.left;
        }
    }

    public int kthSmallest2(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest2(root.left, k);
        }
        if (k > count + 1) {
            return kthSmallest2(root.right, k - 1 - count);
        }
        return root.val;
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}

