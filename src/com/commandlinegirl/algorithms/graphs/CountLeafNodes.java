package com.commandlinegirl.algorithms.graphs;

import com.commandlinegirl.algorithms.datastructures.BinarySearchTree.Node;

/**
 * Count leaf nodes in a binary tree.
 */
public class CountLeafNodes {

    public int countLeafs(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeafs(root.left) + countLeafs(root.right);
    }
}
