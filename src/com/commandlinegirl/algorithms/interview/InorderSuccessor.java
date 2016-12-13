package com.commandlinegirl.algorithms.interview;

public class InorderSuccessor {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode getSuccessor(TreeNode a, int b) {
        if (a == null)
            return null;
        TreeNode root = a;

        TreeNode bNode = find(a, b);
        if (bNode == null)
            return null;
        System.out.println("Found: " + bNode.val);

        // Case 1: a has a right child - find the left-most child of a
        // Case 2: a has no right child - find the nearest ancestor for which
        // the bNode is in the left subtree
        if (bNode.right != null) {
            return findMin(bNode.right);
        }
        return getNearestAncestor(root, bNode);

    }

    private TreeNode getNearestAncestor(TreeNode root, TreeNode current) {
        TreeNode successor = null;
        TreeNode ancestor = root;
        while (ancestor != null && ancestor != successor) {
            if (current.val < ancestor.val) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return successor;
    }

    private TreeNode findMin(TreeNode n) {
        while (n.left != null)
            n = n.left;
        return n;
    }

    private TreeNode find(TreeNode a, int b) {
        while (a != null && a.val != b) {
            if (b < a.val) {
                a = a.left;
            } else if (b > a.val) {
                a = a.right;
            }
        }
        return a;
    }


}
