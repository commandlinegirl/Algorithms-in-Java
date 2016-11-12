package com.commandlinegirl.algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null)
            return l;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            l.add(q.peek().val);
            while (size > 0) {
                TreeNode n = q.remove();
                if (n.right != null)
                    q.add(n.right);
                if (n.left != null)
                    q.add(n.left);
                size--;
            }
        }
        return l;
    }
}
