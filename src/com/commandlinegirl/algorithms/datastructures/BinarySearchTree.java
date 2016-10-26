package com.commandlinegirl.algorithms.datastructures;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    public static class Node {
        public Node left;
        public Node right;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node createNode(int val) {
        return new Node(val);
    }

    public Node insert(Node root, int val) {
        if (root == null)
            return createNode(val);
        if (val < root.val)
            root.left  = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);
        return root;
    }

    public Node delete(Node root, int val) {
        if (root == null )
            return null;
        if (val < root.val)
            root.left = delete(root.left, val);
        else if (val > root.val)
            root.right = delete(root.right, val);
        else if (root.left != null && root.right != null) { // two children
            root.val = getMin(root.right).val; // replace the smallest element with root
            root.right = delete(root.right, root.val); // remove the prev smallest element (duplicate)
        }
        else // one or zero children
            root = (root.left != null ) ? root.left : root.right;
        return root;
    }

    private Node getMin(Node root) {
        if (root == null)
            return null;
        if (root.left == null)
            return root;
        return getMin(root.left);
    }

    public Node searchParent(Node n, int val, Node parent) {
        if (n == null)
            return null;
        if (n.val == val)
            return parent;
        if (val < n.val)
            return searchParent(n.left, val, n);
        else
            return searchParent(n.right, val, n);
    }

    private Node search(Node n, int val) {
        if (n == null)
            return null;
        if (n.val == val)
            return n;
        if (val < n.val)
            return search(n.left, val);
        else
            return search(n.right, val);    }

    public List<Integer> inOrder(Node n) {
        List<Integer> list = new ArrayList<>();
        if (n == null)
            return list;
        list.addAll(inOrder(n.left));
        list.add(n.val);
        list.addAll(inOrder(n.right));
        return list;
    }
}
