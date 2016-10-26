package com.commandlinegirl.algorithms.graphs.test;

import com.commandlinegirl.algorithms.datastructures.BinarySearchTree;
import com.commandlinegirl.algorithms.graphs.CountNodesInRange;
import org.junit.Assert;
import org.junit.Test;

public class CountNodesInRangeTest {

    @Test
    public void testCountNodesInRange1() {
        BinarySearchTree.Node root = new BinarySearchTree.Node(10);
        BinarySearchTree b = new BinarySearchTree();
        b.insert(root, 5);
        b.insert(root, 50);
        b.insert(root, 1);
        b.insert(root, 40);
        b.insert(root, 100);
        CountNodesInRange e = new CountNodesInRange();
        int res = e.count1(root, 5, 45);
        Assert.assertEquals(3, res);
    }


    @Test
    public void testCountNodesInRange2() {
        BinarySearchTree.Node root = new BinarySearchTree.Node(10);
        BinarySearchTree b = new BinarySearchTree();
        b.insert(root, 5);
        b.insert(root, 50);
        b.insert(root, 1);
        b.insert(root, 40);
        b.insert(root, 100);
        CountNodesInRange e = new CountNodesInRange();
        int res = e.count2(root, 5, 45);
        Assert.assertEquals(3, res);
    }
}
