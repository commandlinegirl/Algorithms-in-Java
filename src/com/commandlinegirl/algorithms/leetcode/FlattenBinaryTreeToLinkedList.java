package com.commandlinegirl.algorithms.leetcode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null) {
            flatten(root.right);
        }
        else {
            flatten(root.left);
            TreeNode tmp = root.right;
            root.right = root.left;
            TreeNode rightmostLeft = root.left;
            while (rightmostLeft.right != null) {
                rightmostLeft = rightmostLeft.right;
            }
            rightmostLeft.right = tmp;
            root.left = null;
            flatten(root.right);
        }
    }
}
