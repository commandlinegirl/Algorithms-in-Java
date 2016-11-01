package com.commandlinegirl.algorithms.datastructures;

public class RedBlackTree {

    public static class Node {
        public Node parent;
        public Node left;
        public Node right;
        public Color color;
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
        Node node = insertBst(root, val, Color.RED);
        if (root.left == null && root.right == null) {
            node.color = Color.BLACK;
        }
        // If parent is BLACK, we're done
        if (node.parent == null || node.parent.color.equals(Color.BLACK))
            return node;

        // If parent is RED, we check the uncle.
        Node uncle = getSibling(node.parent);
        if (uncle != null && uncle.color.equals(Color.RED)) {
            // if parent's parent is root, recolor, else recolor and recheck for a need to rotate
            if (isGrandParentRoot(node)) {
                //TODO recolor
            }
            else {
                //TODO recolor and possibly rotate
            }
        }
        else {
            rotate(node);
        }
        return node;
    }

    private boolean isGrandParentRoot(Node node) {
        return node.parent != null &&
                node.parent.parent != null &&
                node.parent.parent.parent == null;
    }

    private void rotate(Node node) {
        if (node == null || node.parent == null || node.parent.parent == null)
            return;
        // RR
        if (!isLeftChild(node.parent.parent, node.parent) && !isLeftChild(node.parent, node)) {
            rotateLeft(node, true);
        }
        //RL
        //TODO
        //LL
        if (!isLeftChild(node.parent.parent, node.parent) && !isLeftChild(node.parent, node)) {
            rotateRight(node, true);
        }
        //LR
        //TODO
    }

    private void rotateLeft(Node node, boolean changeColor) {
        if (node == null || node.parent == null || node.parent.parent == null)
            return;
        Node grandParent = node.parent.parent;
        grandParent.right = node;
        node.left = node.parent;
        node.parent.right = null;
        if (changeColor) {
            flipColor(node);
            flipColor(node.parent);
        }
    }

    private void rotateRight(Node node, boolean changeColor) {
        if (node == null || node.parent == null || node.parent.parent == null)
            return;
        Node grandParent = node.parent.parent;
        grandParent.left = node;
        node.right = node.parent;
        node.parent.left = null;
        if (changeColor) {
            flipColor(node);
            flipColor(node.parent);
        }
    }

    private void flipColor(Node node) {
        if (node == null)
            return;
        if (node.color.equals(Color.BLACK))
            node.color = Color.RED;
        else
            node.color = Color.BLACK;
    }

    private Node getSibling(Node node) {
        if (node == null || node.parent == null)
            return null;
        Node parent = node.parent;
        if (parent.left == node)
            return node.right;
        return parent.left; //TODO: recheck
    }

    private boolean isLeftChild(Node parent, Node node) {
        return parent.left == node;
    }

    public void delete(Node n) {
    }

    public void search(Node n) {
    }

    /**
     * Returns true if the tree passes color validation.
     * @param root
     * @return
     */
    public boolean validate(Node root) {
        return (root == null ||
                root.color.equals(Color.BLACK)
                        && !existsRedChildParentRelation(root)
                        && equalBlackPaths(root));
    }

    /**
     * Returns true if the tree meets a requirement of each root to leaf
     * paths having equal number of black nodes.
     * @param root
     * @return
     */
    private boolean equalBlackPaths(Node root) {
        return blackHeight(root) != -1;
    }

    /**
     * Returns -1 is there exists a node for which left node's black
     * height is not equal to right node's black height. Otherwise returns
     * the black height of the tree.
     * @param node
     * @return
     */
    private int blackHeight(Node node) {
        if (node == null)
            return 0;

        int left = blackHeight(node.left);
        if (left == -1)
            return -1;

        int right = blackHeight(node.right);
        if (right == -1)
            return -1;

        if (left != right)
            return -1;

        int countBlack = node.color.equals(Color.BLACK) ? 1 : 0;
        return countBlack + left; // left is equal to right so we can take either
    }

    /**
     * Returns true if there exists a red-red parent-child relationship in the tree.
     * @param root
     * @return
     */
    private boolean existsRedChildParentRelation(Node root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return false;
        if (root.left == null)
            return root.color.equals(Color.RED) && root.right.color.equals(Color.RED);
        if (root.right == null)
            return root.color.equals(Color.RED) && root.left.color.equals(Color.RED);
        return existsRedChildParentRelation(root.left) || existsRedChildParentRelation(root.right);
    }
}
