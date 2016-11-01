package com.commandlinegirl.algorithms.datastructures.test;

import com.commandlinegirl.algorithms.datastructures.RedBlackTree;
import com.commandlinegirl.algorithms.datastructures.RedBlackTree.Color;
import com.commandlinegirl.algorithms.datastructures.RedBlackTree.Node;
import org.junit.Assert;
import org.junit.Test;

public class RedBlackTreeTest {

    @Test
    public void testValidate1() {
        Node n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;

        n0 = new Node(Color.BLACK, 0);
        n1 = new Node(Color.BLACK, 1);
        n2 = new Node(Color.RED, 2);
        n3 = new Node(Color.RED, 3);
        n4 = new Node(Color.BLACK, 4);
        n5 = new Node(Color.RED, 5);
        n6 = new Node(Color.BLACK, 6);
        n7 = new Node(Color.BLACK, 7);
        n8 = new Node(Color.RED, 8);
        n9 = new Node(Color.BLACK, 9);
        n6.left = n2;
        n6.right = n8;
        n2.left = n0;
        n2.right = n4;
        n8.left = n7;
        n8.right = n9;
        n4.left = n3;
        n4.right = n5;
        RedBlackTree b = new RedBlackTree();
        boolean valid = b.validate(n6);
        Assert.assertTrue(valid);
    }

    @Test
    public void testValidate2() {
        Node n0, n1, n2;

        n0 = new Node(Color.BLACK, 0);
        n1 = new Node(Color.RED, 1);
        n2 = new Node(Color.RED, 2);
        n0.left = n1;
        n0.right = n2;

        RedBlackTree b = new RedBlackTree();
        boolean valid = b.validate(n0);
        Assert.assertTrue(valid);
    }

    @Test
    public void testValidate3() {
        Node n0;
        n0 = new Node(Color.BLACK, 0);

        RedBlackTree b = new RedBlackTree();
        boolean valid = b.validate(n0);
        Assert.assertTrue(valid);
    }

    @Test
    public void testValidate4() {
        Node n0, n1, n2, n3;

        n0 = new Node(Color.BLACK, 0);
        n1 = new Node(Color.RED, 1);
        n2 = new Node(Color.RED, 2);
        n3 = new Node(Color.RED, 3);
        n0.left = n1;
        n0.right = n2;
        n2.left = n3;

        RedBlackTree b = new RedBlackTree();
        boolean valid = b.validate(n0);
        Assert.assertFalse(valid);
    }

    @Test
    public void testValidate5() {
        Node n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;

        n0 = new Node(Color.BLACK, 0);
        n1 = new Node(Color.BLACK, 1);
        n2 = new Node(Color.RED, 2);
        n3 = new Node(Color.RED, 3);
        n4 = new Node(Color.BLACK, 4);
        n5 = new Node(Color.RED, 5);
        n6 = new Node(Color.BLACK, 6);
        n7 = new Node(Color.BLACK, 7);
        n8 = new Node(Color.RED, 8);
        n9 = new Node(Color.BLACK, 9);
        n6.left = n2;
        n6.right = n8;
        n2.left = n0;
        n2.right = n4;
        RedBlackTree b = new RedBlackTree();
        boolean valid = b.validate(n6);
        Assert.assertTrue(valid);
    }
}
