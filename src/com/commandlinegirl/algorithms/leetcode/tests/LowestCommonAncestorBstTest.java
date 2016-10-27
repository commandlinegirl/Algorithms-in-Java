package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.LowestCommonAncestorBst;
import com.commandlinegirl.algorithms.leetcode.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LowestCommonAncestorBstTest {

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
    public void testLowestCommonAncestorBst1() {
        LowestCommonAncestorBst b = new LowestCommonAncestorBst();
        TreeNode lca = b.lowestCommonAncestor(n6, n2, n8);
        Assert.assertEquals(6, lca.val);
    }

    @Test
    public void testLowestCommonAncestorBst2() {
        LowestCommonAncestorBst b = new LowestCommonAncestorBst();
        TreeNode lca = b.lowestCommonAncestor(n6, n2, n4);
        Assert.assertEquals(2, lca.val);
    }

    @Test
    public void testLowestCommonAncestorBst3() {
        LowestCommonAncestorBst b = new LowestCommonAncestorBst();
        TreeNode lca = b.lowestCommonAncestor(n6, n2, n2);
        Assert.assertEquals(2, lca.val);
    }
}
