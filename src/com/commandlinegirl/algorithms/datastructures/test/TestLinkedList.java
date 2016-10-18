package com.commandlinegirl.algorithms.datastructures.test;

import com.commandlinegirl.algorithms.datastructures.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class TestLinkedList {

    @Test
    public void testReverseList_iter_full_list() {
        LinkedList.Node<String> a = new LinkedList.Node<>("a");
        LinkedList.Node<String> b = new LinkedList.Node<>("b");
        LinkedList.Node<String> c = new LinkedList.Node<>("c");
        LinkedList.Node<String> d = new LinkedList.Node<>("d");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        LinkedList.Node newStart = LinkedList.reverseIterative(a);
        Assert.assertEquals("d", newStart.data());
        Assert.assertEquals("c", newStart.getNext().data());
        Assert.assertEquals("b", newStart.getNext().getNext().data());
        Assert.assertEquals("a", newStart.getNext().getNext().getNext().data());
    }

    @Test
    public void testReverseList_iter_one_element_list() {
        LinkedList.Node<String> a = new LinkedList.Node<>("a");

        LinkedList.Node newStart = LinkedList.reverseIterative(a);
        Assert.assertEquals("a", newStart.data());
        Assert.assertNull(newStart.getNext());
    }

    @Test
    public void testReverseList_recur_full_list() {
        LinkedList.Node<String> a = new LinkedList.Node<>("a");
        LinkedList.Node<String> b = new LinkedList.Node<>("b");
        LinkedList.Node<String> c = new LinkedList.Node<>("c");
        LinkedList.Node<String> d = new LinkedList.Node<>("d");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        LinkedList.Node newStart = LinkedList.reverseRecursive1(a);
        Assert.assertEquals("d", newStart.data());
        Assert.assertEquals("c", newStart.getNext().data());
        Assert.assertEquals("b", newStart.getNext().getNext().data());
        Assert.assertEquals("a", newStart.getNext().getNext().getNext().data());
    }

    @Test
    public void testReverseList_recur_one_element_list() {
        LinkedList.Node<String> a = new LinkedList.Node<>("a");

        LinkedList.Node newStart = LinkedList.reverseRecursive1(a);
        Assert.assertEquals("a", newStart.data());
        Assert.assertNull(newStart.getNext());
    }

    @Test
    public void testMiddleNode_ok() {
        LinkedList.Node<String> a = new LinkedList.Node<>("a");
        LinkedList.Node<String> b = new LinkedList.Node<>("b");
        LinkedList.Node<String> c = new LinkedList.Node<>("c");
        LinkedList.Node<String> d = new LinkedList.Node<>("d");
        LinkedList.Node<String> e = new LinkedList.Node<>("e");
        LinkedList.Node<String> f = new LinkedList.Node<>("f");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);

        LinkedList.Node mid = LinkedList.middleNode(a);
        Assert.assertEquals("c", mid.data());
    }

}
