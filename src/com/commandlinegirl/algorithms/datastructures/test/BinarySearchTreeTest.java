package com.commandlinegirl.algorithms.datastructures.test;

import com.commandlinegirl.algorithms.datastructures.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest {
    
    @Test
    public void testBinarySearchTreeInsert() {
        BinarySearchTree.Node root = new BinarySearchTree.Node(50);
        BinarySearchTree b = new BinarySearchTree();
        b.insert(root, 30);
        b.insert(root, 20);
        b.insert(root, 40);
        b.insert(root, 70);
        b.insert(root, 60);
        b.insert(root, 80);
        List<Integer> exp = Arrays.asList(20, 30, 40, 50, 60, 70, 80);
        List<Integer> res = b.inOrder(root);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void testBinarySearchTreeDelete() {
        BinarySearchTree.Node root = new BinarySearchTree.Node(50);
        BinarySearchTree b = new BinarySearchTree();
        b.insert(root, 30);
        b.insert(root, 20);
        b.insert(root, 40);
        b.insert(root, 70);
        b.insert(root, 60);
        b.insert(root, 80);
        BinarySearchTree.Node res = b.delete(root, 50);
        List<Integer> expTree = Arrays.asList(20, 30, 40, 60, 70, 80);
        List<Integer> resTree = b.inOrder(root);
        Assert.assertEquals(expTree, resTree);
        Assert.assertEquals(60, res.val);
    }
}
