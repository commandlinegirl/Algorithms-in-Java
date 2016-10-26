package com.commandlinegirl.algorithms.graphs;

import com.commandlinegirl.algorithms.datastructures.BinarySearchTree.Node;

/**
 * Given a Binary Search Tree (BST) and a range, count1 the number of nodes in the BST that lie in the given range.
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700139
 */
public class CountNodesInRange {

    public int count1(Node root, int low, int high) {
        if (root == null)
            return 0;

        int current = 0;
        if (root.val >= low)
            current = 1;
        if (root.val > high)
            current = 0;
        return count1(root.left, low, high) + current + count1(root.right, low, high);
    }


    public int count2(Node root, int low, int high) {
        if (root == null)
            return 0;

        if (root.val < low)
            return count2(root.right, low, high);
        if (root.val > high)
            return count2(root.left, low, high);
        else
            return count2(root.left, low, high) + 1 + count2(root.right, low, high);
    }

}
