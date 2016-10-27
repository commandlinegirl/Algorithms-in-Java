package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.MinDepthBinaryTree;
import com.commandlinegirl.algorithms.leetcode.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinDepthBinaryTreeTest {

    TreeNode n0;
    TreeNode n1;
    TreeNode n2;
    TreeNode n3;
    TreeNode n4;
    TreeNode n5;
    TreeNode n6;
    TreeNode n7;
    TreeNode n8;
    TreeNode n9;

    @Before
    public void setup() {
        n0 = new TreeNode(0);
        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(5);
        n6 = new TreeNode(6);
        n7 = new TreeNode(7);
        n8 = new TreeNode(8);
        n9 = new TreeNode(9);
        n6.left = n2;
        n6.right = n8;
        n2.left = n0;
        n2.right = n4;
        n8.left = n7;
        n8.right = n9;
        n4.left = n3;
        n4.right = n5;
    }

    @Test
    public void testMinDepthBinaryTree1() {
        MinDepthBinaryTree b = new MinDepthBinaryTree();
        int tn = b.minDepthRec(n6);
        Assert.assertEquals(3, tn);
    }

    @Test
    public void testMinDepthBinaryTree2() {
        MinDepthBinaryTree b = new MinDepthBinaryTree();
        int tn = b.minDepthIter(n6);
        Assert.assertEquals(3, tn);
    }
}
