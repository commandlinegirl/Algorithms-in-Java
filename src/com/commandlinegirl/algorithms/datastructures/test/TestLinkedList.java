package com.commandlinegirl.algorithms.datastructures.test;

import com.commandlinegirl.algorithms.datastructures.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class TestLinkedList {

    @Test
    public void testReverseList_full_list() {
        LinkedList.Node<String> a = new LinkedList.Node<>("a");
        LinkedList.Node<String> b = new LinkedList.Node<>("b");
        LinkedList.Node<String> c = new LinkedList.Node<>("c");
        LinkedList.Node<String> d = new LinkedList.Node<>("d");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        LinkedList.Node newStart = LinkedList.reverse(a);
        Assert.assertEquals("d", newStart.data());
        Assert.assertEquals("c", newStart.getNext().data());
        Assert.assertEquals("b", newStart.getNext().getNext().data());
        Assert.assertEquals("a", newStart.getNext().getNext().getNext().data());
    }

    @Test
    public void testReverseList_one_element_list() {
        LinkedList.Node<String> a = new LinkedList.Node<>("a");

        LinkedList.Node newStart = LinkedList.reverse(a);
        Assert.assertEquals("a", newStart.data());
        Assert.assertNull(newStart.getNext());
    }
}
