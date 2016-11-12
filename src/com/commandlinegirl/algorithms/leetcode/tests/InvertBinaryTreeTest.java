package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.InvertBinaryTree;
import com.commandlinegirl.algorithms.leetcode.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvertBinaryTreeTest {

    private TreeNode n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;

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
    public void testInvert1() {
        InvertBinaryTree b = new InvertBinaryTree();
        TreeNode inverted = b.invertTree(n6);
        List<Integer> inOrderVals = inOrder(inverted);
        Assert.assertEquals(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 0), inOrderVals);
        Assert.assertEquals(6, inverted.val);
    }

    @Test
    public void testInvert2() {
        InvertBinaryTree b = new InvertBinaryTree();
        TreeNode inverted = b.invertTree(n4);
        List<Integer> inOrderVals = inOrder(inverted);
        Assert.assertEquals(Arrays.asList(5, 4, 3), inOrderVals);
        Assert.assertEquals(4, inverted.val);
    }

    @Test
    public void testInvert3() {
        InvertBinaryTree b = new InvertBinaryTree();
        TreeNode inverted = b.invertTree(n3);
        List<Integer> inOrderVals = inOrder(inverted);
        Assert.assertEquals(Arrays.asList(3), inOrderVals);
        Assert.assertEquals(3, inverted.val);
    }

    private List<Integer> inOrder(TreeNode n) {
        List<Integer> list = new ArrayList<>();
        if (n == null)
            return list;
        list.addAll(inOrder(n.left));
        list.add(n.val);
        list.addAll(inOrder(n.right));
        return list;
    }
}
