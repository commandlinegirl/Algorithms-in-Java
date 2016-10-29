package com.commandlinegirl.algorithms.datastructures;

public class RedBlackTree {

    public static class Node {
        public Node left;
        public Node right;
        public Color color; // 0 for black, 1 for red
        public int val;

        public Node(Color color, int val) {
            this.color = color;
            this.val = val;
        }
    }
    public enum Color {
        RED,
        BLACK,
    }

    private Node createNode(Color color, int val) {
        return new Node(color, val);
    }

    private Node insertBst(Node root, int val, Color color) {
        if (root == null)
            return createNode(color, val);
        if (val < root.val)
            root.left  = insertBst(root.left, val, color);
        else if (val > root.val)
            root.right = insertBst(root.right, val, color);
        return root;
    }

    public Node insert(Node root, int val) {
        Node n = insertBst(root, val, Color.RED); // insert initially as red
        if (root.left == null && root.right == null) { // node is root
            n.color = Color.BLACK;
        }
        // the parent is black - trivial

        // the parent is red



        return n;
    }

    public void delete(Node n) {
    }

    public void search(Node n) {
    }

    public boolean validate(Node root) {
        return (root == null ||
                root.color.equals(Color.BLACK)
                        && !existsRedChildParent(root)
                        && equalBlackPaths(root));
    }

    private boolean equalBlackPaths(Node root) {
        return blackHeight(root) != -1;
    }

    private int blackHeight(Node node) {
        if (node == null)
            return 0;

        int left = blackHeight(node.left);
        if (left == -1)
            return -1;

        int right = blackHeight(node.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 0)
            return -1;

        int countBlack = node.color.equals(Color.BLACK) ? 1 : 0;
        return countBlack + left; // left is equal to right so we can take either
    }

    private boolean existsRedChildParent(Node root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return false;
        if (root.left == null)
            return root.color.equals(Color.RED) && root.right.color.equals(Color.RED);
        if (root.right == null)
            return root.color.equals(Color.RED) && root.left.color.equals(Color.RED);
        return existsRedChildParent(root.left) || existsRedChildParent(root.right);

    }

}
