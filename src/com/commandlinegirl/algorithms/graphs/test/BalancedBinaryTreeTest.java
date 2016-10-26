package com.commandlinegirl.algorithms.graphs.test;

import com.commandlinegirl.algorithms.graphs.BalancedBinaryTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BalancedBinaryTreeTest {

    @Test
    public void testBalancedBinaryTree1() {
        BalancedBinaryTree.TreeNode n1 = new BalancedBinaryTree.TreeNode(1);
        BalancedBinaryTree.TreeNode n2 = new BalancedBinaryTree.TreeNode(2);
        BalancedBinaryTree.TreeNode n3 = new BalancedBinaryTree.TreeNode(3);
        n1.right = n2;
        n1.left = n3;
        BalancedBinaryTree b = new BalancedBinaryTree();
        boolean isBalanced = b.isBalanced(n1);
        Assert.assertTrue(isBalanced);
    }

    @Test
    public void testBalancedBinaryTree2() {
        BalancedBinaryTree.TreeNode n1 = new BalancedBinaryTree.TreeNode(1);
        BalancedBinaryTree.TreeNode n2 = new BalancedBinaryTree.TreeNode(2);
        BalancedBinaryTree.TreeNode n3 = new BalancedBinaryTree.TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        BalancedBinaryTree b = new BalancedBinaryTree();
        boolean isBalanced = b.isBalanced(n1);
        Assert.assertFalse(isBalanced);
    }

    @Test
    public void testBalancedBinaryTree3() {
        BalancedBinaryTree.TreeNode n1 = new BalancedBinaryTree.TreeNode(1);
        BalancedBinaryTree.TreeNode n2 = new BalancedBinaryTree.TreeNode(2);
        n1.right = n2;
        BalancedBinaryTree b = new BalancedBinaryTree();
        boolean isBalanced = b.isBalanced(n1);
        Assert.assertTrue(isBalanced);
    }

}
