package com.commandlinegirl.algorithms.interview.test;

import com.commandlinegirl.algorithms.interview.InorderSuccessor;
import com.commandlinegirl.algorithms.interview.InorderSuccessor.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeInorderSuccessorTest {

    private TreeNode n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;

    @Test
    public void testBinInorderTraversal1() {
        TreeNode n0 = new TreeNode(0);
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

        InorderSuccessor is = new InorderSuccessor();
        TreeNode inOrderVals = is.getSuccessor(n6, 2);
        Assert.assertEquals(n3, inOrderVals);
    }

}
