package com.commandlinegirl.algorithms.graphs.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.commandlinegirl.algorithms.datastructures.BinaryTree.Node;
import com.commandlinegirl.algorithms.graphs.BalancedTree;

public class TestBalancedTree {
    
    private Node tree1node;
    private Node tree2node;
    
    @Before
    public void setupTest() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        c.setLeft(e);
        c.setRight(f);
        e.setLeft(g);
        tree1node = a;
        
        Node aa = new Node("A");
        Node bb = new Node("B");
        Node cc = new Node("C");
        Node dd = new Node("D");
        Node ee = new Node("E");
        Node gg = new Node("G");
        aa.setLeft(bb);
        bb.setLeft(dd);
        aa.setRight(cc);
        cc.setLeft(ee);
        ee.setLeft(gg);
        tree2node = aa;
    }
    
    @Test
    public void testBalancedTree() {
        assertTrue(BalancedTree.isBalanced(tree1node));
        assertFalse(BalancedTree.isBalanced(tree2node));
    }
}
