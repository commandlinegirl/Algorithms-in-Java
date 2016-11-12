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
        n1.right = n2;
        n2.left = n3;
        BinaryTreeInorderIterative b = new BinaryTreeInorderIterative();
        List<Integer> inOrderVals = b.inorderTraversal(n1);
        Assert.assertEquals(Arrays.asList(1,3,2), inOrderVals);
    }

    @Test
    public void testBinInorderTraversal2() {
        TreeNode n1 = new TreeNode(1);
        BinaryTreeInorderIterative b = new BinaryTreeInorderIterative();
        List<Integer> inOrderVals = b.inorderTraversal(n1);
        Assert.assertEquals(Arrays.asList(1), inOrderVals);

    }
}
