package com.commandlinegirl.algorithms.leetcode;

import java.util.*;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderIterative {

    public List<Integer> inorderTraversalVisitedHashmap(TreeNode root) {
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

    public List<Integer> inorderTraversalPushLeftNodes(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        pushLeftNodes(s, root);
        while (!s.empty()) {
            TreeNode tn = s.pop();
            vals.add(tn.val);
            pushLeftNodes(s, tn.right);
        }

        return vals;
    }

    private void pushLeftNodes(Stack<TreeNode> s, TreeNode n) {
        while (n != null) {
            s.push(n);
            n = n.left;
        }
    }

    public List<Integer> inorderTraversalWithVisited(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null)
            return vals;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode n = s.peek();
            if (n.left != null && !n.left.visited) {
                s.push(n.left);
                n.left.visited = true;
            }
            else {
                n = s.pop();
                vals.add(n.val);
                if (n.right != null)
                    s.push(n.right);
            }
        }

        return vals;
    }

    public List<Integer> inorderTraversalShortVersion(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null)
            return vals;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (!s.empty() || cur != null)  {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            vals.add(cur.val);
            cur = cur.right;
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
          public boolean visited;
          public TreeNode(int x) { val = x; }
     }

}
