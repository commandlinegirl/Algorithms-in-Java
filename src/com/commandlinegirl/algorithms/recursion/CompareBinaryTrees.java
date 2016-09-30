package com.commandlinegirl.algorithms.recursion;

import com.commandlinegirl.algorithms.datastructures.BinaryTree;

/**
 *  Write a function to compare whether two binary trees are identical.
 *  Identical trees have the same key value at each position and the same structure.
 *
 *  Source: http://www.algorist.com/algowiki/index.php/Data-structures-TADM2E
 */
public class CompareBinaryTrees {

    public static boolean compare(BinaryTree.Node a, BinaryTree.Node b) {

        if (a == null && b == null)
            return true;

        if (a == null || b == null || !a.getName().equals(b.getName())) {
            return false;
        }

        boolean left = compare(a.getLeft(), b.getLeft());
        boolean right = compare(a.getRight(), b.getRight());

        return left && right;
    }
}
