package com.commandlinegirl.algorithms.leetcode;

import java.util.*;

public class BinTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        if (root == null)
            return order;

        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> s = new Stack<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelList = new ArrayList<>();
            while (levelSize > 0) {
                TreeNode tn = q.remove();
                levelList.add(tn.val);
                if (tn.left != null) {
                    q.add(tn.left);
                }
                if (tn.right != null) {
                    q.add(tn.right);
                }
                levelSize--;
            }
            s.push(levelList);
        }

        while (!s.empty()) {
            order.add(s.pop());
        }
        return order;
    }
}
