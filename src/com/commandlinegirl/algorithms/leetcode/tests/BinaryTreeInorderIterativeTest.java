package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.BinaryTreeInorderIterative;
import com.commandlinegirl.algorithms.leetcode.BinaryTreeInorderIterative.TreeNode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeInorderIterativeTest {

    @Test
    public void testBinInorderTraversal1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.right = n2;
        n1.left = n3;
        n3.left = n4;
        n4.left = n6;
        n4.right = n5;
        BinaryTreeInorderIterative b = new BinaryTreeInorderIterative();
        List<Integer> inOrderVals = b.inorderTraversal(n1);
        Assert.assertEquals(Arrays.asList(6, 4, 5, 3, 1, 2), inOrderVals);
    }

    @Test
    public void testBinInorderTraversal2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.right = n2;
        n1.left = n3;
        n3.left = n4;
        n4.left = n6;
        n4.right = n5;
        BinaryTreeInorderIterative b = new BinaryTreeInorderIterative();
        List<Integer> inOrderVals = b.inorderTraversal2(n1);
        Assert.assertEquals(Arrays.asList(6, 4, 5, 3, 1, 2), inOrderVals);
    }

    @Test
    public void testBinInorderTraversal3() {
        TreeNode n1 = new TreeNode(1);
        BinaryTreeInorderIterative b = new BinaryTreeInorderIterative();
        List<Integer> inOrderVals = b.inorderTraversal(n1);
        Assert.assertEquals(Arrays.asList(1), inOrderVals);

    }

    @Test
    public void testBinInorderTraversal4() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.right = n2;
        n1.left = n3;
        n3.left = n4;
        n4.left = n6;
        n4.right = n5;
        BinaryTreeInorderIterative b = new BinaryTreeInorderIterative();
        List<Integer> inOrderVals = b.inorderTraversalWithVisited(n1);
        Assert.assertEquals(Arrays.asList(6, 4, 5, 3, 1, 2), inOrderVals);
    }

}
