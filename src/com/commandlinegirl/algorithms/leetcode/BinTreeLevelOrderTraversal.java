package com.commandlinegirl.algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class BinTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> levelList = new ArrayList<>();
            while (level > 0) {
                TreeNode n = q.remove();
                levelList.add(n.val);
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
                level--;
            }
            ret.add(levelList);
        }
        return ret;
    }

    /**
     * Prints the nodes in a level order.
     * @param root
     * @return
     */
    public List<Integer> levelOrder2(TreeNode root) {
        List<Integer> levelOrder = new ArrayList<>();
        if (root == null)
            return levelOrder;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            levelOrder.add(n.val);
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
        return levelOrder;
    }

    /**
     * Level-order traversal using two queues.
     * Time complexity: O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        current.add(root);
        List<Integer> levelList = new ArrayList<>();

        while (!current.isEmpty()) {
            TreeNode n = current.poll();
            levelList.add(n.val);
            if (n.left != null)
                next.add(n.left);
            if (n.right != null)
                next.add(n.right);

            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                ret.add(levelList);
                levelList = new ArrayList<>();
            }
        }

        return ret;
    }
}
