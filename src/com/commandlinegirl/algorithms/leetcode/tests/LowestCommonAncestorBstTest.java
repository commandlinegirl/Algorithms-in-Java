package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.BinaryTreeInorderIterative;
import com.commandlinegirl.algorithms.leetcode.LowestCommonAncestorBst;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LowestCommonAncestorBstTest {

    LowestCommonAncestorBst.TreeNode n0;
    LowestCommonAncestorBst.TreeNode n1;
    LowestCommonAncestorBst.TreeNode n2;
    LowestCommonAncestorBst.TreeNode n3;
    LowestCommonAncestorBst.TreeNode n4;
    LowestCommonAncestorBst.TreeNode n5;
    LowestCommonAncestorBst.TreeNode n6;
    LowestCommonAncestorBst.TreeNode n7;
    LowestCommonAncestorBst.TreeNode n8;
    LowestCommonAncestorBst.TreeNode n9;

    @Before
    public void setup() {
        n0 = new LowestCommonAncestorBst.TreeNode(0);
        n1 = new LowestCommonAncestorBst.TreeNode(1);
        n2 = new LowestCommonAncestorBst.TreeNode(2);
        n3 = new LowestCommonAncestorBst.TreeNode(3);
        n4 = new LowestCommonAncestorBst.TreeNode(4);
        n5 = new LowestCommonAncestorBst.TreeNode(5);
        n6 = new LowestCommonAncestorBst.TreeNode(6);
        n7 = new LowestCommonAncestorBst.TreeNode(7);
        n8 = new LowestCommonAncestorBst.TreeNode(8);
        n9 = new LowestCommonAncestorBst.TreeNode(9);
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
    public void testLowestCommonAncestorBst1() {
        LowestCommonAncestorBst b = new LowestCommonAncestorBst();
        LowestCommonAncestorBst.TreeNode lca = b.lowestCommonAncestor(n6, n2, n8);
        Assert.assertEquals(6, lca.val);
    }

    @Test
    public void testLowestCommonAncestorBst2() {
        LowestCommonAncestorBst b = new LowestCommonAncestorBst();
        LowestCommonAncestorBst.TreeNode lca = b.lowestCommonAncestor(n6, n2, n4);
        Assert.assertEquals(2, lca.val);
    }

    @Test
    public void testLowestCommonAncestorBst3() {
        LowestCommonAncestorBst b = new LowestCommonAncestorBst();
        LowestCommonAncestorBst.TreeNode lca = b.lowestCommonAncestor(n6, n2, n2);
        Assert.assertEquals(2, lca.val);
    }
}
